package edu.uca.aca2016.swing.rest;

import com.google.gson.annotations.Expose;

public class Error{

    @Expose
    protected String error_message = null;
    @Expose
    protected String error = null;

    public Error(String error){
        this.error = error;
    }

    @Override
    public String toString(){
        if((this.error != null && !this.error.isEmpty())
            && (this.error_message != null && !this.error_message.isEmpty())){
            return this.error + " " + this.error_message;
        }
        if((this.error == null || this.error.isEmpty())
            && (this.error_message != null && !this.error_message.isEmpty())){
            return this.error_message;
        }
        if((this.error != null && !this.error.isEmpty())
            && (this.error_message == null || this.error_message.isEmpty())){
            return this.error;
        }
        return new String();
    }
}
