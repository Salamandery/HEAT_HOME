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
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author rodolfo.abreu
 */
public class ThreadSaturnoSystemRecebe extends Thread {

    private static String Unidade, local, location;
    private final Socket cliente;

    public ThreadSaturnoSystemRecebe(Socket cliente) {
        this.cliente = cliente;
    }

    private static void getConfig() {
        Unidade = PjConfig.mp.getPropriedade(PjConfig.configSistema, "UnIdAdE");
        local = PjConfig.mp.getPropriedade(PjConfig.configSistema, "LoCal");
        local = Unidade + local;
    }

    public void run() {
        try {
            getConfig();
            location = local;
            DataInputStream dis = new DataInputStream(cliente.getInputStream());
            // Obter nome do arquivo
            String nomeArquivo = dis.readUTF();
            // Obter tamanho do arquivo
            int tam = dis.readInt();
            if (tam > 0) {
                jLogConsole.ShowMessageListener("Notificação Saturno System Server:", "Existem notificações de recebimento de imagem", TrayIcon.MessageType.INFO);
                jLogConsole.jTxtAreaLogSai.append("\nArquivo recebido " + nomeArquivo + " Tamanho: " + tam + " bytes\nOrigem: IP_Address"+cliente.getRemoteSocketAddress());
                // Criação de fluxo de saida
                // Localização dos arquivos
                new File(location + nomeArquivo + "\\").mkdirs();
                location = local + nomeArquivo + "\\";
                FileOutputStream fos = new FileOutputStream(location + nomeArquivo);
                BufferedOutputStream out = new BufferedOutputStream(fos);
                BufferedInputStream in = new BufferedInputStream(cliente.getInputStream());
                // Criação de array de bytes
                byte[] buffer = new byte[tam];
                // Pegando arquivos por bytes
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = (byte) in.read();
                }
                //Escrição de Arquivo
                out.write(buffer);
                //Fechamento de fluxo
                out.flush();
                in.close();
                out.close();
            }
            //Fechamento de fluxo
            cliente.close();
        } catch (IOException e) {
            Logging.LoggingSys(this.getClass(), e, "FATAL");
            jLogConsole.ShowMessageListener("Notificação Saturno System Server:", "Ops.. Acho que tivemos alguma intecorrência com nosso serviço", TrayIcon.MessageType.WARNING);
            jLogConsole.jTxtAreaLogSai.append("\nExcecao ocorrida na thread: " + e.getMessage() + "\n");
            try {
                cliente.close();
            } catch (IOException ec) {
                jLogConsole.ShowMessageListener("Notificação Saturno System Server:", "Houve um problema ao fechar o serviço. Nada tão grave assim, ufa....", TrayIcon.MessageType.ERROR);
                Logging.LoggingSys(this.getClass(), ec, "ERROR");
            }
        }
    }
}
