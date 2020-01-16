package Server;


import Server.Func.Logging;
import com.sun.security.auth.module.NTSystem;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.function.Supplier;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rodolfo.abreu
 */
public class PjConfig extends javax.swing.JFrame {
    
    // Arquivo config    
    private static NTSystem infoSystem = new NTSystem();
    public static String caminho = "C:/Users/"+(infoSystem.getName())+"/AppData/Roaming/tempSys/conf/";
    public static String arquivo = "conConfig.properties";
    public static ManipuladorProperties mp = new ManipuladorProperties();
    public static Properties configSistema = mp.carregarPropriedades(caminho+arquivo);
    
    /**
     * Creates new form PjConfig1
     */
    public PjConfig() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnGravar = new javax.swing.JButton();
        jTxtIP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jBQuit = new javax.swing.JButton();
        jTxtUser = new javax.swing.JTextField();
        jTxtPass = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Configuração");
        setAlwaysOnTop(true);
        setResizable(false);

        jBtnGravar.setText("Salvar");
        jBtnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGravarActionPerformed(evt);
            }
        });

        jLabel1.setText("Endereço de IP:");

        jBQuit.setText("Sair");
        jBQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBQuitActionPerformed(evt);
            }
        });

        jLabel2.setText("Usuário:");

        jLabel3.setText("Senha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBQuit))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtUser)
                            .addComponent(jTxtIP, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(jTxtPass))))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGravar)
                    .addComponent(jBQuit))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("");
        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGravarActionPerformed
        
        mp = new ManipuladorProperties();
        configSistema = mp.carregarPropriedades(caminho + arquivo); 
        mp.incluirPropriedade("L0giN", jTxtUser.getText(), configSistema);
        mp.incluirPropriedade("PaSs", jTxtPass.getText(), configSistema);
        mp.incluirPropriedade("uRl", "jdbc:postgresql://"+jTxtIP.getText()+":5432/heat", configSistema);
        mp.salvar(configSistema, caminho + "conConfig.properties"); 
        
    }//GEN-LAST:event_jBtnGravarActionPerformed

    private void jBQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBQuitActionPerformed

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
            java.util.logging.Logger.getLogger(PjConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PjConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PjConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PjConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PjConfig().setVisible(true);
            }
        });
    }
    
    public static class ManipuladorProperties {
    
    public Properties carregarPropriedades(String origem) {
        FileInputStream arquivoConfig = null;

        Properties configSistema = new Properties();

        try {
            arquivoConfig = new FileInputStream(origem);

            configSistema.load(arquivoConfig);
        }
        catch(FileNotFoundException e) {
            Logging.LoggingSys(this.getClass(), e, "WARN");
            JOptionPane.showMessageDialog(((Supplier<JDialog>) () -> {
                final JDialog dialog = new JDialog();
                dialog.setAlwaysOnTop(true);
                return dialog;
            }).get(), e);
        }
        catch(IOException e) {
            Logging.LoggingSys(this.getClass(), e, "WARN");
            JOptionPane.showMessageDialog(((Supplier<JDialog>) () -> {
                final JDialog dialog = new JDialog();
                dialog.setAlwaysOnTop(true);
                return dialog;
            }).get(), e);
        }
        finally {
            try {
                arquivoConfig.close();
            }
            catch(IOException e) {
                
                Logging.LoggingSys(this.getClass(), e, "WARN");
                JOptionPane.showMessageDialog(((Supplier<JDialog>) () -> {
                    final JDialog dialog = new JDialog();
                    dialog.setAlwaysOnTop(true);
                    return dialog;
                }).get(), e);
            }
        }

        return configSistema;
    }
    
        
    public static String getPropriedade(Properties propriedades, String propriedade) {
        return propriedades.getProperty(propriedade);
    }
    
    public Properties incluirPropriedade(String chave,
                                         String valor,
                                         Properties propriedades) {
        propriedades.put(chave, valor);

        return propriedades;
    }
    public Properties removerPropriedade(String chave, Properties propriedades) {
        propriedades.remove(chave);

        return propriedades;
    }
    public void salvar(Map propriedades, String destino) {
        FileWriter fw = null;
        
        try {
            fw = new FileWriter(destino);

            Set<String> valores = propriedades.keySet();
            for(String valor: valores) {
                fw.write(valor + "=" + propriedades.get(valor) + "\r\n");
            }
        }
        catch(FileNotFoundException e) {
            Logging.LoggingSys(this.getClass(), e, "WARN");
            JOptionPane.showMessageDialog(((Supplier<JDialog>) () -> {
                final JDialog dialog = new JDialog();
                dialog.setAlwaysOnTop(true);
                return dialog;
            }).get(), e);
        }
        catch(IOException e) {
            Logging.LoggingSys(this.getClass(), e, "WARN");
            JOptionPane.showMessageDialog(((Supplier<JDialog>) () -> {
                final JDialog dialog = new JDialog();
                dialog.setAlwaysOnTop(true);
                return dialog;
            }).get(), e);
        }
        finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            }
            catch(IOException e) {
                Logging.LoggingSys(this.getClass(), e, "WARN");
                JOptionPane.showMessageDialog(((Supplier<JDialog>) () -> {
                    final JDialog dialog = new JDialog();
                    dialog.setAlwaysOnTop(true);
                    return dialog;
                }).get(), e);
            }
        }
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBQuit;
    private javax.swing.JButton jBtnGravar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTxtIP;
    private javax.swing.JTextField jTxtPass;
    private javax.swing.JTextField jTxtUser;
    // End of variables declaration//GEN-END:variables
}