/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Func;

import Server.PjConfig;
import Server.Func.Logging;
import Server.jLogConsole;
import java.awt.TrayIcon;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author rodolfo.abreu
 */
public class ThreadSaturnoSystem extends Thread {

    private static String Unidade, local, location;
    private final Socket cliente;

    public ThreadSaturnoSystem(Socket cliente) throws SocketException {
        this.cliente = cliente;
        cliente.setSoTimeout(5000);
        cliente.setKeepAlive(true);
    }

    private static void getConfig() {
        Unidade = PjConfig.mp.getPropriedade(PjConfig.configSistema, "UnIdAdE");
        local = PjConfig.mp.getPropriedade(PjConfig.configSistema, "LoCal");
        local = Unidade + local;
    }

    public String obterRotaCorrigidaWindows(String rota, String separador, String novoSeparador) {

        StringTokenizer tokens = new StringTokenizer(rota, separador);
        //Para guardar rota
        String rotaCorrigida = new String();
        //Contar tokens
        // nome do arquivo selecionado
        int noTokens = tokens.countTokens();
        int i = 1;
        do {      // agregar ao separador
            rotaCorrigida += tokens.nextToken() + novoSeparador;
            i++;
        } while (i < noTokens);
        //agregar rota corrigida ao nome do arquivo
        rotaCorrigida += tokens.nextToken();
        //Imprime rota corrigida
        
        jLogConsole.jTxtAreaLogEnt.append("\n\n############# CONVERTENDO TOKENS ############################"+"\n\n"+rotaCorrigida + "\n" + noTokens + " tokens");
        return rotaCorrigida;
    }

    public void run() {
        try {
            getConfig();
            location = local;
            //ObjectInputStream para receber o nome do arquivo
            DataInputStream dis = new DataInputStream(cliente.getInputStream());
            //Recebe o nome do arquivo
            String nomeArquivo = dis.readUTF();
            //location = location + nomeArquivo + "\\";
            //location = location + "\\";
            //Leitura do arquivo solicitado
            // Criando fluxo
            DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
            File file = new File(obterRotaCorrigidaWindows(location + nomeArquivo, "\\", "\\\\"));
            // Obter tamanho do arquivo
            int tam = (int) file.length();
            //Envia Informaçoes do arquivo
            dos.writeUTF(file.getName());
            dos.writeInt(tam);
            //Criando fluxo de envio
            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());

            oos.writeObject(file.getName());

            FileInputStream fis = new FileInputStream(file);
            byte [] buffer = new byte[tam];
            Integer bytesRead = 0;

            while ((bytesRead = fis.read(buffer)) > 0) {
                oos.writeObject(bytesRead);
                oos.writeObject(Arrays.copyOf(buffer, buffer.length));
            }
            //ObjectInputStream para receber o nome do arquivo
            /*DataInputStream entrada = new DataInputStream(cliente.getInputStream());
            //Recebe o nome do arquivo
            String nomeArquivo = entrada.readUTF();
            //location = location + nomeArquivo + "\\";
            //location = location + "\\";
            //Leitura do arquivo solicitado
            // Criando fluxo
            DataOutputStream saida = new DataOutputStream(cliente.getOutputStream());
            File file = new File(obterRotaCorrigidaWindows(location + nomeArquivo, "\\", "\\\\"));
            // Obter tamanho do arquivo
            int tam = (int) file.length();

            // Enviamos o nome do arquivo
            saida.writeUTF(nomeArquivo);
            // Enviamos o tamanho do arquivo
            saida.writeInt(tam);

            if (tam > 0) {
                jLogConsole.ShowMessageListener("Notificação Saturno System Server:", "Existem notificações de requisição de atualização", TrayIcon.MessageType.INFO);
                // Criação do fluxo de saida do array
                FileInputStream fis = new FileInputStream(file);
                //BufferedImage bimg = ImageIO.read(new File(location + nomeArquivo));

                //ImageIO.write(bimg, "JAR", cliente.getOutputStream());

                BufferedInputStream bis = new BufferedInputStream(fis);
                BufferedOutputStream bos = new BufferedOutputStream(cliente.getOutputStream());
                // Criação do array de bytes
                byte[] buffer = new byte[tam];

                // Leitura do arquivo em bytes
                //bis.read(buffer);
                bos.write(buffer);
            //Lendo os bytes do arquivo e enviando para o socket     
            for (int i = 0; i < buffer.length; i++) {
                bos.write(buffer[i]);
                //buffer[i] = (byte) bos.write();
            }*/
                jLogConsole.jTxtAreaLogEnt.append("\nCliente atendido com sucesso: \n" + nomeArquivo
                        + "\nTamanho: " + tam + " bytes\nDestino: IP_Address"+cliente.getRemoteSocketAddress());
            dos.flush();
            cliente.close();
            oos.close();
            ois.close();
        } catch (IOException e) {
            Logging.LoggingSys(this.getClass(), e, "FATAL");
            jLogConsole.ShowMessageListener("Notificação Saturno System Server:", "Ops.. Acho que tivemos alguma intecorrência com nosso serviço", TrayIcon.MessageType.WARNING);
            jLogConsole.jTxtAreaLogEnt.append("\nExcecao ocorrida na thread: " + e.getMessage() + "\nPerigo, perigo... Contate o suporte, talvez seja urgente!!!!!!!! =(");
            try {
                cliente.close();
            } catch (IOException ec) {
                jLogConsole.ShowMessageListener("Notificação Saturno System Server:", "Houve um problema ao fechar o serviço. Nada tão grave assim, ufa....", TrayIcon.MessageType.ERROR);
                Logging.LoggingSys(this.getClass(), ec, "ERROR");
            }
        }
    }
}
