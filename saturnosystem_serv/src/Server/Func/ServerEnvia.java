/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Func;

import Server.Func.ThreadSaturnoSystem;
import Server.Func.Logging;
import Server.jLogConsole;
import java.awt.TrayIcon;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author rodolfo.abreu
 */
public class ServerEnvia extends Thread {

    /*public static void main(String[] args) throws IOException {
        ServerSocket servidor;
        //JOptionPane.showMessageDialog(null, "Serviço iniciado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        ServerEnvia p = new ServerEnvia();
        servidor = new ServerSocket(5100);

        p.iniciarServidor(servidor);
    }*/
    public void iniciarServidor(ServerSocket servidor) {
        while (true) {
            try {
                // Criação do socket de leitura
                Socket cliente = servidor.accept();
                // Criando fluxo de entrada para ler dados do cliente
                // Obter nome do arquivo
                // Mensagem recebida
                new ThreadSaturnoSystem(cliente).start();
            } catch (IOException e) {
                Logging.LoggingSys(this.getClass(), e, "ERROR");
                jLogConsole.ShowMessageListener("Notificação Saturno System Server:", "Aconteceu alguma coisa... Entre em contato com suporte antes que seja tarde demais.", TrayIcon.MessageType.WARNING);
                jLogConsole.jTxtAreaLogEnt.append("\nExcecao ocorrida na thread: " + e.getMessage() + "\nPerigo, perigo... Contate o suporte, talvez seja urgente!!!!!!!! =(");
                jLogConsole.jTxtAreaLogSai.append("\nRecebi " + e.toString() + "\n");

            }
        }
    }
}
