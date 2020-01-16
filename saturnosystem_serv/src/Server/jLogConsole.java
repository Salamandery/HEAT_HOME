/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Server.Func.ServerRecebe;
import Server.Func.ServerEnvia;
import Server.Func.Logging;
import java.awt.AWTException;
import static java.awt.Frame.NORMAL;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author rodolfo.abreu
 */
public class jLogConsole extends javax.swing.JFrame {

    public static TrayIcon trayIcon = null;
    private static jLogConsole obj = null;
    private SystemTray tray = SystemTray.getSystemTray();
    private String stats;
    private ServerRecebe r;
    private ServerEnvia e;

    /**
     * Creates new form jLogConsole
     * @return 
     */
    
    private List<Image> WinIcon() {
        List<Image> icons = new ArrayList<Image>();
        ImageIcon ico = new ImageIcon("C:\\SaturnoSystem\\ico\\Logo.png");
        Image icon = ico.getImage();
        icon = icon.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH);
        icons.add(icon);
        
        icon = icon.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
        icons.add(icon);
        
        icon = icon.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        icons.add(icon);
        
        
        return icons;
    }
    
    public static jLogConsole getObj() {
        if (obj == null) {
            obj = new jLogConsole();
        }
        return obj;
    }

    public static void ShowMessageListener(String title, String msg, TrayIcon.MessageType messageType) {
        
        trayIcon.displayMessage(title, msg, messageType);
    }

    public jLogConsole() {
        initComponents();
        setIconImages(WinIcon());
        stats = "aberta";
        // verifica se o sistema aceita sistema de trayicon
        if (SystemTray.isSupported()) {

            //setando o icone
            Image image = Toolkit.getDefaultToolkit().getImage("C:\\SaturnoSystem\\ico\\Logo.png");
            image = image.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
            //ImageIcon logo = new ImageIcon(image);
            // criando popup
            PopupMenu popup = new PopupMenu("Menu de Opções");
            // criando tray icon e suas configuraçoes
            trayIcon = new TrayIcon(image, "Servidor: Saturno System", popup);
            trayIcon.setImageAutoSize(true);

            try {

                tray.add(trayIcon);
                jLogConsole.ShowMessageListener("Notificação Saturno System Server:", "Seja Bem-vindo ao sistema Saturno System Server. Estarei cuidando de tudo para você..", TrayIcon.MessageType.NONE);
            } catch (AWTException e) {
                Logging.LoggingSys(this.getClass(), e, "FATAL");

            }

            //listener para que a janela se abra com
            //o clique do mouse
            trayIcon.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (stats.equals("aberta") && isVisible()) {
                        //esconde a janela
                        setVisible(false);
                        stats = "minimiza";
                    } else {
                        //reabre a janela
                        setVisible(true);
                        //quando a janela for reaberta
                        setExtendedState(NORMAL);
                        toFront();
                        stats = "aberta";
                    }
                }

            });
        }
        
        Thread thrEnvia = new Thread() {
            public void run() {
                try {
                    ServerSocket servidor;
                    e = new ServerEnvia();
                    servidor = new ServerSocket(5100);

                    e.iniciarServidor(servidor);
                } catch (IOException ex) {
                    Logging.LoggingSys(this.getClass(), ex, "FATAL");
                    jLogConsole.jTxtAreaLogSai.append("\n\n############# FECHANDO SESSÃO ###################################\n");
                }

            }
        };
        thrEnvia.start();

        Thread thrRecebe = new Thread() {
            public void run() {
                try {
                    ServerSocket servidor;
                    r = new ServerRecebe();
                    servidor = new ServerSocket(5000);

                    r.iniciarServidor(servidor);
                } catch (IOException ex) {
                    Logging.LoggingSys(this.getClass(), ex, "FATAL");
                    jLogConsole.jTxtAreaLogEnt.append("\n\n############# FECHANDO SESSÃO ###################################\n");
                }

            }
        };
        thrRecebe.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtAreaLogEnt = new javax.swing.JTextArea();
        jBtnEnt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTxtAreaLogSai = new javax.swing.JTextArea();
        jBtnSai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor - Saturno System");
        setResizable(false);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        jTxtAreaLogEnt.setEditable(false);
        jTxtAreaLogEnt.setColumns(20);
        jTxtAreaLogEnt.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTxtAreaLogEnt.setRows(5);
        jTxtAreaLogEnt.setText("############# ESPERANDO SESSÃO ##################################");
        jTxtAreaLogEnt.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        jScrollPane1.setViewportView(jTxtAreaLogEnt);

        jBtnEnt.setText("Limpar");
        jBtnEnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEntActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnEnt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Requisições de Imagem", jPanel1);

        jTxtAreaLogSai.setEditable(false);
        jTxtAreaLogSai.setColumns(20);
        jTxtAreaLogSai.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTxtAreaLogSai.setRows(5);
        jTxtAreaLogSai.setText("############# ESPERANDO SESSÃO ##################################");
        jTxtAreaLogSai.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        jScrollPane2.setViewportView(jTxtAreaLogSai);

        jBtnSai.setText("Limpar");
        jBtnSai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnSai, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnSai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Entrada de Imagem", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnEntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEntActionPerformed
        // TODO add your handling code here:
        jTxtAreaLogEnt.setText("############# ESPERANDO SESSÃO ##################################\n");
    }//GEN-LAST:event_jBtnEntActionPerformed

    private void jBtnSaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSaiActionPerformed
        // TODO add your handling code here:
        jTxtAreaLogSai.setText("############# ESPERANDO SESSÃO ##################################\n");
    }//GEN-LAST:event_jBtnSaiActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:

        //adiciona uma ação ao frame, para monitorar alterações de status
        //da janela
        //checa se a janela foi minimizada
        if (evt.getNewState() == ICONIFIED) {
            //esconde janela
            setVisible(false);
            stats = "minimiza";
        }

        if (evt.getNewState() == NORMAL) {
            //esconde a janela
            setVisible(true);
            setExtendedState(NORMAL);
            stats = "aberta";
        }
        if (evt.getNewState() == 7) {
            //esconde a janela
            setVisible(false);
            stats = "minimiza";
        }
    }//GEN-LAST:event_formWindowStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jLogConsole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jLogConsole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jLogConsole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jLogConsole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jLogConsole().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEnt;
    private javax.swing.JButton jBtnSai;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextArea jTxtAreaLogEnt;
    public static javax.swing.JTextArea jTxtAreaLogSai;
    // End of variables declaration//GEN-END:variables
}
