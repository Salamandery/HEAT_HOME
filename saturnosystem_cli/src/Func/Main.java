/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Func;

import Telas.jFrmLogin;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.JFrame;

/**
 *
 * @author rodolfo.abreu
 */
public class Main extends javax.swing.JFrame {

    /**
     * @param args the command line arguments
     */
    public static Connection con = null;
    public static ResultSet rs = null;
    public static Statement st = null;
    public static PreparedStatement stmt = null;
    // Icon
    TrayIcon trayIcon;
    SystemTray tray;
    
    public void HideToSystemTray() {
        if(SystemTray.isSupported()) {
            tray=SystemTray.getSystemTray();

            Image image=Toolkit.getDefaultToolkit().getImage("C:\\SaturnSystem\\bin\\sources\\ico\\Logo.png");
            ActionListener exitListener=new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            };
            PopupMenu popup=new PopupMenu();
            MenuItem defaultItem=new MenuItem("Sair");
            defaultItem.addActionListener(exitListener);
            popup.add(defaultItem);
            defaultItem=new MenuItem("Abrir");
            defaultItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setVisible(true);
                    setExtendedState(JFrame.NORMAL);
                }
            });
            popup.add(defaultItem);
            trayIcon=new TrayIcon(image, "SaturnSystem", popup);
            trayIcon.setImageAutoSize(true);
        } else {
           
        }
        addWindowStateListener((WindowEvent e) -> {
            if (e.getNewState()==ICONIFIED){
                /*listener para que a janela se abra com
                //o clique do mouse
                trayIcon.addMouseListener(new MouseAdapter() {
                            @Override
                   public void mouseClicked(MouseEvent e) {
                        setVisible(true);
                        toFront();
                        //remove o icone da bandeira
                        //quando a janela for reaberta
                        tray.remove(trayIcon);
                   }
                });*/
                try {
                    tray.add(trayIcon);
                    setVisible(false);
                } catch (AWTException ex) {
                    Logging.LoggingSys(this.getClass(), ex, "FATAL");
                }

            }
            if(e.getNewState()==7) {
                try{
                    tray.add(trayIcon);
                    setVisible(false);
                }catch(AWTException ex){
                    Logging.LoggingSys(this.getClass(), ex, "FATAL");
                }
            }
            
            
            if(e.getNewState()==MAXIMIZED_BOTH){
                tray.remove(trayIcon);
                setVisible(true);
            }
            if(e.getNewState()==NORMAL){
                tray.remove(trayIcon);
                setVisible(true);
            }
        });
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\SaturnSystem\\bin\\sources\\ico\\Logo.png"));

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static Connection getConnect(String db, String base) {
        
        switch(db) {
            case "ora":
                try {
                    //Class.forName("oracle.jdbc.driver.OracleDriver");
                    con = DriverManager.getConnection("jdbc:oracle:thin:@10.42.111.211:1521:prdmv","DBAMV","IVKF9080");

                } catch (SQLException ex) {
                    Logging.LoggingSys(null, ex, "FATAL");
                    //System.out.print(ex);
                }
                break;
            case "pgsql":
                try {
                    //Class.forName("oracle.jdbc.driver.OracleDriver");
                    con = DriverManager.getConnection("jdbc:postgresql://10.42.112.48:5432/"+base,"postgres","$up0rte?");

                } catch (SQLException ex) {
                    Logging.LoggingSys(null, ex, "FATAL");
                    //System.out.print(ex);
                }
                break;

        
        }
        
        return con;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException 
                | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            Logging.LoggingSys(null, ex, "ERROR");
        }
        new jFrmLogin().setVisible(true);
    }
    
}
