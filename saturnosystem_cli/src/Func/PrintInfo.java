/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Func;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;

/**
 *
 * @author rodolfo.abreu
 */
public class PrintInfo extends Main{
    
    private void getStatus() {
        new Thread() {
     
        @Override
        public void run() {
            //table.setRowCount(0);
            try {

                st = con.createStatement();
                rs = st.executeQuery("SELECT ip_adress_imp, id_impressora FROM heat.impressoras "
                        + "WHERE sn_ativo = 'S' AND cd_empresa = 1 ORDER BY 2");

                while (rs.next()) {

                    String ipAddress = rs.getString(1);
                    boolean inet = InetAddress.getByName(ipAddress).isReachable(1000);
                    //System.out.println("Sending Ping Request to " + ipAddress);
                    if (inet) {
                      //System.out.println(ipAddress + " is reachable.");
                      //table.addRow(new String[] {rs.getString(2), ipAddress, "OK"});
                    } else {
                      //System.out.println(ipAddress + " NOT reachable.");
                      //table.addRow(new String[] {rs.getString(2), ipAddress, "ALERTA: OFFLINE"});
                    }

                }

            } catch (SQLException ex) {
                Logging.LoggingSys(this.getClass(), ex, "FATAL");
            } catch (UnknownHostException ex) {
                Logging.LoggingSys(this.getClass(), ex, "FATAL");
            } catch (IOException ex) {
                Logging.LoggingSys(this.getClass(), ex, "FATAL");
            }
        }}.start();
    }
    
}
