/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.commons.net.whois.WhoisClient;

/**
 *
 * @author cfiles
 */
public class ApacheCommonsWhois{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        int index;
        String handle, host;
        InetAddress address = null;
        WhoisClient whois;

        if(args.length != 1){
            System.err.println("usage: fwhois handle[@<server>]");
            System.exit(1);
        }

        index = args[0].lastIndexOf("@");

        whois = new WhoisClient();
        
        // set timeout to trip if a response takes longer than 60 seconds
        whois.setDefaultTimeout(60000);

        if(index == -1){
            handle = args[0];
            host = WhoisClient.DEFAULT_HOST;
        }
        else{
            handle = args[0].substring(0,index);
            host = args[0].substring(index + 1);
        }

        try{
            address = InetAddress.getByName(host);
            System.out.println("[" + address.getHostName() + "]");
        }
        catch(UnknownHostException e){
            System.err.println("Error unknown host: " + e.getMessage());
            System.exit(1);
        }

        try{
            whois.connect(address);
            System.out.print(whois.query(handle));
            whois.disconnect();
        }
        catch(IOException e){
            System.err.println("Error I/O exception: " + e.getMessage());
            System.exit(1);
        }
    }
}
