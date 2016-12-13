/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cfiles
 */
public class LoggingExamples{
    private static final Logger logger = Logger.getLogger(LoggingExamples.class.getName());
    
    public LoggingExamples() {
        Level myLevel = Level.ALL;
        
        this.logger.setUseParentHandlers(false);
        
        this.logger.setLevel(myLevel);
        
        ConsoleHandler handler = new ConsoleHandler();
        
        //handler.setFormatter(new MyFormatter());
        
        handler.setLevel(myLevel);
        
        this.logger.addHandler(handler);

        //Filter filter = new MyFilter();
        //logger.setFilter(filter);
    }
    
    public void doSomething() {
        logger.entering(getClass().getName(), "doSomething");

        try{
            logger.log(Level.INFO, "Log my parameter: {0} ", "P1");
            
            logger.info("Straight to an info logger");
        } 
        catch (Exception e) {
            logger.log(Level.SEVERE, "Error doing XYZ", e);
        }

        logger.exiting(getClass().getName(), "doSomething");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        LoggingExamples l = new LoggingExamples();
        
        l.doSomething();
    }
    
}
    