/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Func;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author rodolfo.abreu
 */
public class jInternalFrameControl extends javax.swing.JInternalFrame {
    
    //Desktop e InternalFrame temporarios
    private static JDesktopPane desk;
    private static JInternalFrame frame;
    // distancia entre as janelas
    private static  int offset = 25;

    public static void cascade() {

        // Bordas do JDesktopPane
        //Rectangle dBounds = Desk.getBounds();
        
        // Pega todos os frames e organiza, o ultimo fica mais em baido e mais pra cima
        // quantidade de frames
        int i = desk.getAllFrames().length;
        for (JInternalFrame f : desk.getAllFrames()) {
            //Seletor de frames
            //multiplicando entre eles
            //Dimensão do desktop
            Dimension d = desk.getSize();
            f.setLocation((d.width - f.getSize().width) / 2, i * offset);
            //System.out.println(f.getLocation()+"-"+i);
            i--;
        }
    }

    /*public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, jFrmPrincipal.jDPnl.getAllFrames().length*25);
    }*/
    
    private static void setPosicao() {
        Dimension d = desk.getSize();
        frame.setLocation((d.width - frame.getSize().width) / 2, offset);
    }

    public static void OpenITFrame(JInternalFrame Frame, JDesktopPane Desk) {

        desk = Desk;
        frame = Frame;

        for (JInternalFrame jInternalFrame : desk.getAllFrames()) {
            // se uma janela semelhante estiver aberta
            if (jInternalFrame.getClass().toString().equalsIgnoreCase(frame.getClass().toString())) {
                // traz janela para frente para facilitar a escolha
                jInternalFrame.moveToFront();
                //Object[] opções = {"Continuar com Formulário Ativo", "Abrir Novo Formulário"};
                int qst = JOptionPane.showConfirmDialog(null,
                        "O Formulário que deseja abrir já está ativo no momento."
                        + "\nDeseja abrir um Novo Formulário?",
                        "Mensagem.",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                // se utilizar a aberta retorna e não abre outra,
                // caso contrário sai do for e abre outra igual
                if (qst == JOptionPane.YES_OPTION) {
                    break;
                } else {
                    return;
                }
            }
        }
        // adiciona na tela
        desk.add(frame);
        // seta visivel
        frame.setVisible(true);
        setPosicao();
        if (desk.getAllFrames().length > 1) {
            cascade();
        }
    }
}