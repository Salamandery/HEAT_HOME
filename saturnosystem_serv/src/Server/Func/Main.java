package Server.Func;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rodolfo.abreu
 */
import Server.jLogConsole;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        jLogConsole.getObj().setVisible(true);
        //JOptionPane.showMessageDialog(null, "Serviço iniciado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    public Main() throws IOException {
        // Creamos socket servidor escuchando en el mismo puerto donde se comunica el cliente
        // en este caso el puerto es el 4400
        System.out.println("Servidores Online...");
    }
}
