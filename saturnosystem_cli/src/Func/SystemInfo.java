/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Func;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import static java.lang.management.ManagementFactory.getOperatingSystemMXBean;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author rodolfo.abreu
 */
public class SystemInfo {
    
   public String getMac() { 
        String Mac = null;
                
        try {
                InetAddress address = InetAddress.getLocalHost();
                NetworkInterface ni = NetworkInterface.getByInetAddress(address);
                byte[] mac = ni.getHardwareAddress();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < mac.length; i++) {
                    Mac = String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
                    sb.append(Mac);
                }
                if (sb.toString().length() <= 18) {
                    Mac = sb.toString();
                }
        } catch (UnknownHostException | SocketException e) {
            Logging.LoggingSys(Main.class, e, "ERROR");
        }
        return Mac;
   }
   
   private void getInfo() {
    
    // VARIAVEIS ip adress
    
    InetAddress Ip;
    
    // VARIAVEIS INT
    
    int availableProcessors;
    
    // VARIAVEIS LONG
    
    long maxMemory;
    long memorySize;
    long hdUsed;
    long hdTotal;
    long hdFree;
        
        try {
            
        // IP e HOST do cliente
        
           Ip = InetAddress.getLocalHost();
           //jTxtip.setText("IP: "+Ip.getHostAddress());
           //jTxtHost.setText("HOST: "+Ip.getHostName());
           
        // Calculos em byte
        
           hdTotal = new File("C:/").getTotalSpace() / 1073741824;
           hdFree = new File("C:/").getFreeSpace() /  1073741824;
           hdUsed = (new File("C:/").getTotalSpace() / 1073741824) - hdFree;
           memorySize = ((com.sun.management.OperatingSystemMXBean) 
                   ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize() / 1000000000;
           maxMemory = Runtime.getRuntime().maxMemory() / 1000000000;
           
        // Imprime informações
        
           //System.out.println(Long.toString(maxMemory));
           //jTxtRAM.setText("RAM: "+Long.toString(memorySize)+" GB.");
           //jTxtEdit.setText("HD: "+Long.toString(hdTotal)+" GB. TOTAL");
           //jTxtEdit2.setText("HD: "+Long.toString(hdFree)+" GB. LIVRE");
           //jTxtEdit3.setText("HD: "+Long.toString(hdUsed)+" GB. USADO");
           
        } catch (UnknownHostException ex) {
            Logging.LoggingSys(this.getClass(), ex, "FATAL");
        }
        
        // Nucleos CPU
        
           availableProcessors = getOperatingSystemMXBean().getAvailableProcessors();
           //System.out.println(availableProcessors);
        
        // Informações do Computador 
        new Thread() {
     
        @Override
        public void run() {
            // VARIAVEL DE PROCESSOS EM TEMPO DE EXECUÇAO - CPU 
    
            Runtime runtime = Runtime.getRuntime();
            Process process;
           
            try {

                 process = runtime.exec("systeminfo");
                 BufferedReader systemInformationReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                 StringBuilder stringBuilder = new StringBuilder();
                 String line;

                 while ((line = systemInformationReader.readLine()) != null) {
                     stringBuilder.append(line);
                     stringBuilder.append(System.lineSeparator());
                 }  

                 //System.out.println(stringBuilder.toString().trim());
                 //jTxtBox.append(stringBuilder.toString().trim());

             } catch (IOException ex) {
                 Logging.LoggingSys(this.getClass(), ex, "ERROR");
             }
        }}.start();
        
        
    }
}
