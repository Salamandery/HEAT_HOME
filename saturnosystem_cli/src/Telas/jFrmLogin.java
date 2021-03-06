/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Func.Logging;
import Func.Main;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author rodolfo.abreu
 */
public class jFrmLogin extends Main {

    /**
     * Creates new form jFrmPrincipal
     */
    
    public jFrmLogin() {
        initComponents();
        con = getConnect("pgsql", "heat.monitor");
        HideToSystemTray();
        this.setExtendedState(this.getExtendedState() | this.ICONIFIED);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlBody = new javax.swing.JPanel();
        jPnlMenu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPwField = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBtnClose = new javax.swing.JButton();
        jBtnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("jFrmPrincipal");
        setName("jFrmPrincipal"); // NOI18N
        setUndecorated(true);

        jPnlBody.setBackground(new java.awt.Color(0, 51, 153));

        jPnlMenu.setBackground(new java.awt.Color(0, 51, 153));
        jPnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("HEAT - HOME");

        jTField.setBackground(new java.awt.Color(51, 102, 255));
        jTField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTField.setForeground(new java.awt.Color(255, 255, 255));
        jTField.setBorder(null);

        jPwField.setBackground(new java.awt.Color(51, 102, 255));
        jPwField.setForeground(new java.awt.Color(255, 255, 255));
        jPwField.setToolTipText("");
        jPwField.setBorder(null);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Login de Acesso:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Senha:");

        jBtnClose.setBackground(new java.awt.Color(255, 0, 0));
        jBtnClose.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtnClose.setForeground(new java.awt.Color(255, 255, 255));
        jBtnClose.setText("Fechar");
        jBtnClose.setFocusPainted(false);
        jBtnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCloseActionPerformed(evt);
            }
        });

        jBtnEntrar.setBackground(new java.awt.Color(255, 0, 0));
        jBtnEntrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEntrar.setText("Entrar");
        jBtnEntrar.setFocusPainted(false);
        jBtnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(jPwField)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jBtnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addComponent(jTField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPwField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPnlBodyLayout = new javax.swing.GroupLayout(jPnlBody);
        jPnlBody.setLayout(jPnlBodyLayout);
        jPnlBodyLayout.setHorizontalGroup(
            jPnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlBodyLayout.createSequentialGroup()
                .addComponent(jPnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPnlBodyLayout.setVerticalGroup(
            jPnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void getLogin() {
        
        try {
            stmt = con.prepareStatement("SELECT * FROM heat.usuarios WHERE cd_usuario = ?");
            stmt.setString(1, jTField.getText());
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                new jFrmPrincipal().setVisible(true);
                this.dispose();
            } else {
                //Logging.LoggingSys(this.getClass(), );
                JOptionPane.showMessageDialog(this, "Login ou Senha inválidos", "Problema de autenticação", INFORMATION_MESSAGE);
                Logging.LoggingSys(this.getClass(), "Login ou Senha inválidos", "INFO");
            }
        } catch (SQLException ex) {
            Logging.LoggingSys(this.getClass(), ex, "FATAL");
        }
    }
    
    private void jBtnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCloseActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBtnCloseActionPerformed

    private void jBtnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEntrarActionPerformed
        // TODO add your handling code here:
        getLogin();
    }//GEN-LAST:event_jBtnEntrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnClose;
    private javax.swing.JButton jBtnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPnlBody;
    private javax.swing.JPanel jPnlMenu;
    private javax.swing.JPasswordField jPwField;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTField;
    // End of variables declaration//GEN-END:variables
}
