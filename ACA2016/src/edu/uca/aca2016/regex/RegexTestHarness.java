package edu.uca.aca2016.regex;

import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
    US Phone number: ^\(?([0-9]{3})\)?[-.\s]?([0-9]{3})[-.\s]?([0-9]{4})$
    SSN: ^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$
    Email: http://howtodoinjava.com/regex/java-regex-validate-email-address/
*/

public class RegexTestHarness{

    public static void main(String[] args){
        Console console = System.console();
        
        if(console == null){
            System.err.println("No console.");
            System.exit(1);
        }
        
        while(true){
            Pattern pattern = Pattern.compile(console.readLine("%nEnter your regex: "));

            Matcher matcher = pattern.matcher(console.readLine("Enter input string to search: "));

            boolean found = false;
            
            while(matcher.find()){
                console.format("I found the text \"%s\" starting at index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
                found = true;
            }
            
            if(!found){
                console.format("No match found.%n");
            }
        }
    }
}
