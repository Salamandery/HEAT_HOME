/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Func;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author rodolfo.abreu
 */
public class Logging {
    
    private static Logger logger;
    
    private static void Configure() {
        
        String log4jConfPath = "C:/Users/rodolfo.abreu/AppData/Roaming/tempSys/conf/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        //System.setProperty("log4j.properties", "%AppData%\\tempSys\\conf");
        System.setProperty("com.mchange.v2.log.MLog", "com.mchange.v2.log.FallbackMLog");
        System.setProperty("com.mchange.v2.log.FallbackMLog.DEFAULT_CUTOFF_LEVEL", "WARNING"); 
        
    }
    
    public static void LoggingSys(Class name, Throwable error, String level) {
                
        Configure();
        
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        error.printStackTrace(pw);
        logger = LogManager.getLogger(name);
        
        switch (level) {
            case "DEBUG":
                logger.debug(sw.toString());
                break;
            case "INFO":
                logger.info(sw.toString());
                break;
            case "WARN":
                logger.warn(sw.toString());
                break;
            case "FATAL":
                logger.fatal(sw.toString());
                break;
            case "ERROR":
                logger.error(sw.toString());
                break;
            default:
                System.out.println(sw.toString());
        }  
    }
    public static void LoggingSys(Class name, String msg, String level) {
        
        Configure();
        
        //StringWriter sw = new StringWriter();
        //PrintWriter pw = new PrintWriter(sw);
        //error.printStackTrace(pw);
        logger = LogManager.getLogger(name);
        //System.out.println(msg);
        switch (level) {
            case "DEBUG":
                logger.debug(msg);
                break;
            case "INFO":
                logger.info(msg);
                break;
            case "WARN":
                logger.warn(msg);
                break;
            case "FATAL":
                logger.fatal(msg);
                break;
            case "ERROR":
                logger.error(msg);
                break;
            default:
                System.out.println(msg);
        }  
    }
   
}
