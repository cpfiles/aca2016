/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.objects;

import java.io.Serializable;

/**
 *
 * @author cfiles
 */
public class Message implements Serializable{
    private Level type;
    private String message;
    
    public enum Level {
        ERROR, INFO;
        
        public String getString() {
            return this.name();
        }
    }

    public Message(){
        
    }
    
    public Message(Level type,String message){
        this.type = type;
        this.message = message;
    }

    public Level getType(){
        return type;
    }

    public void setType(Level type){
        this.type = type;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        return "Message{" + "type=" + type + ", message=" + message + '}';
    }
}
