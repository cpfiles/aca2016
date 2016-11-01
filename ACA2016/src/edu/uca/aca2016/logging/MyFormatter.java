/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.logging;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 *
 * @author cfiles
 */
public class MyFormatter extends Formatter{

    @Override
    public String format(LogRecord record){
        return record.getLevel() + ":" + record.getMessage() + "\r\n";
    }
}
