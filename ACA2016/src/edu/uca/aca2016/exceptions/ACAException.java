/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.exceptions;

/**
 *
 * @author cfiles
 */
public class ACAException extends Exception{

    /**
     * Creates a new instance of <code>ACAException</code> without detail
     * message.
     */
    public ACAException(){
    }

    /**
     * Constructs an instance of <code>ACAException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ACAException(String msg){
        super(msg);
    }
}
