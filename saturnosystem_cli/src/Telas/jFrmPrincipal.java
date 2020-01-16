/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Func.Logging;
import Func.Main;
import static Func.jInternalFrameControl.OpenITFrame;
/**
 *
 * @author rodolfo.abreu
 */
public class jFrmPrincipal extends Main {

    /**
     * Creates new form jFrmPrincipal
     */
    
    //private final DefaultTableModel table;
    
    
    public jFrmPrincipal() {
        initComponents();
        HideToSystemTray();
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        
        con = getConnect("pgsql", "heat.monitor");
        //table = (DefaultTableModel) jTbImp.getModel();
        //getStatus();
        //getInfo();
    }  
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlMain = new javax.swing.JPanel();
        jDPnl = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMOS = new javax.swing.JMenu();
        jMIOSCad = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMIMinhasOS = new javax.swing.JMenuItem();
        jMmListOS = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMIRecb = new javax.swing.JMenuItem();
        jMITransf = new javax.swing.JMenuItem();
        jMPC = new javax.swing.JMenu();
        jMmPC = new javax.swing.JMenu();
        jMICadPC = new javax.swing.JMenuItem();
        jMIReg = new javax.swing.JMenuItem();
        jMIListPC = new javax.swing.JMenuItem();
        jMmPrint = new javax.swing.JMenu();
        jMICadPrint = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMExit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SaturnSytem - INTRANET HEAT");
        setBackground(new java.awt.Color(0, 153, 204));

        jPnlMain.setBackground(new java.awt.Color(0, 153, 204));
        jPnlMain.setToolTipText("");

        jDPnl.setPreferredSize(new java.awt.Dimension(770, 60));

        javax.swing.GroupLayout jDPnlLayout = new javax.swing.GroupLayout(jDPnl);
        jDPnl.setLayout(jDPnlLayout);
        jDPnlLayout.setHorizontalGroup(
            jDPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jDPnlLayout.setVerticalGroup(
            jDPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPnlMainLayout = new javax.swing.GroupLayout(jPnlMain);
        jPnlMain.setLayout(jPnlMainLayout);
        jPnlMainLayout.setHorizontalGroup(
            jPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlMainLayout.createSequentialGroup()
                .addComponent(jDPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPnlMainLayout.setVerticalGroup(
            jPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDPnl, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jMOS.setText("Ordens de Serviço");
        jMOS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMIOSCad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMIOSCad.setText("Cadastro");
        jMOS.add(jMIOSCad);
        jMOS.add(jSeparator1);

        jMIMinhasOS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMIMinhasOS.setText("Ordens de Serviço");
        jMOS.add(jMIMinhasOS);

        jMmListOS.setText("Lista de Ordem de Serviço");
        jMmListOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMmListOSActionPerformed(evt);
            }
        });
        jMOS.add(jMmListOS);
        jMOS.add(jSeparator2);

        jMIRecb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMIRecb.setText("Recebimento");
        jMOS.add(jMIRecb);

        jMITransf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMITransf.setText("Transferência");
        jMOS.add(jMITransf);

        jMenuBar1.add(jMOS);

        jMPC.setText("Máquinas");
        jMPC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMmPC.setText("Computadores");
        jMmPC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMICadPC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMICadPC.setText("Cadastro de Computadores");
        jMmPC.add(jMICadPC);

        jMIReg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMIReg.setText("Histórico de Computadores");
        jMmPC.add(jMIReg);

        jMIListPC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMIListPC.setText("Lista de Computadores");
        jMmPC.add(jMIListPC);

        jMPC.add(jMmPC);

        jMmPrint.setText("Impressoras");
        jMmPrint.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMICadPrint.setText("Cadastro de Impressoras");
        jMmPrint.add(jMICadPrint);

        jMenuItem1.setText("Lista de Impressoras");
        jMmPrint.add(jMenuItem1);

        jMPC.add(jMmPrint);

        jMenuBar1.add(jMPC);

        jMenu1.setText("Controle de Estoque");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Configurações");
        jMenuBar1.add(jMenu2);

        jMExit.setText("Sair");
        jMExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMExitActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMExit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMExitActionPerformed

    private void jMmListOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMmListOSActionPerformed
        // TODO add your handling code here:
        
        try {
            OpenITFrame(new JIFListOS(), jDPnl);
        } catch (Exception ex) {
            Logging.LoggingSys(this.getClass(), ex, "FATAL"); 
        }
    }//GEN-LAST:event_jMmListOSActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane jDPnl;
    private javax.swing.JMenu jMExit;
    private javax.swing.JMenuItem jMICadPC;
    private javax.swing.JMenuItem jMICadPrint;
    private javax.swing.JMenuItem jMIListPC;
    private javax.swing.JMenuItem jMIMinhasOS;
    private javax.swing.JMenuItem jMIOSCad;
    private javax.swing.JMenuItem jMIRecb;
    private javax.swing.JMenuItem jMIReg;
    private javax.swing.JMenuItem jMITransf;
    private javax.swing.JMenu jMOS;
    private javax.swing.JMenu jMPC;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMmListOS;
    private javax.swing.JMenu jMmPC;
    private javax.swing.JMenu jMmPrint;
    private javax.swing.JPanel jPnlMain;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables
}