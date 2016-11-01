/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.logging;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 *
 * @author cfiles
 */
public class MyFilter implements Filter{
    @Override
    public boolean isLoggable(LogRecord record){
        String s = record.getLoggerName();
        
        if (s.contains("LoggingExamples")) {
            return false;
        }
        
        return true;
    }
}
