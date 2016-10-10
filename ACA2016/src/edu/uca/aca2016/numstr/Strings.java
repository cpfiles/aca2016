/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.numstr;

/**
 *
 * @author cfiles
 */
public class Strings{

    public void length(){
        String palindrome = "Dot saw I was Tod";
        int len = palindrome.length();
        char[] tempCharArray = new char[len];
        char[] charArray = new char[len];

        // put original string in an array of chars
        for(int i = 0; i < len; i++){
            tempCharArray[i] = palindrome.charAt(i);
        }

        // reverse array of chars
        for(int j = 0; j < len; j++){
            charArray[j] = tempCharArray[len - 1 - j];
        }

        String reversePalindrome = new String(charArray);
        System.out.println(reversePalindrome);
    }

    public void concat(){
        String s1 = "My name is ";
        String s2 = "Rumplestiltskin";
        String s3 = s1.concat(s2);
        System.out.println(s3);

        System.out.println("My name is ".concat("Rumplestiltskin"));
        System.out.println("My name is " + "Rumplestiltskin");
    }

    public void format(){
        System.out.printf("The value of the float "
            + "variable is %f, while "
            + "the value of the "
            + "integer variable is %d, "
            + "and the string is %s%n",
                          2.2,5,"my string");
    }

    public void stringsToNumbers(String[] args){
        if(args.length == 2){
            // convert strings to numbers
            float a = (Float.valueOf(args[0])).floatValue();
            float b = (Float.valueOf(args[1])).floatValue();

            // do some arithmetic
            System.out.println("a + b = " + (a + b));
            System.out.println("a - b = " + (a - b));
            System.out.println("a * b = " + (a * b));
            System.out.println("a / b = " + (a / b));
            System.out.println("a % b = " + (a % b));
        }
        else{
            System.out.println("This program requires two command-line arguments.");
        }
    }

    public void numbersToStrings(){
        double d = 858.48;
        String s = Double.toString(d);

        int dot = s.indexOf('.');

        System.out.println(dot + " digits " + "before decimal point.");
        System.out.println((s.length() - dot - 1) + " digits after decimal point.");
    }

    public void substring(){
        String anotherPalindrome = "Niagara. O roar again!";
        String roar = anotherPalindrome.substring(11,15);
        System.out.println(roar);
    }

    public void stringManip(){
        String s = "The quick brown fox, jumps over the lazy dog ";

        System.out.println("Before trim: '" + s + "'. After trim: '" + s.trim() + "'");
        System.out.println("Uppercase: " + s.toUpperCase());
        System.out.println("Lowercase: " + s.toLowerCase());

        String[] x = s.split(",");
        System.out.println("Split on the comma:");
        for(int i = 0; i < x.length; i++){
            System.out.println("\t index " + i + ": " + x[i]);
        }
    }

    public class Filename{

        protected String fullPath;
        protected char pathSeparator, extensionSeparator;

        public Filename(String str,char sep,char ext){
            fullPath = str;
            pathSeparator = sep;
            extensionSeparator = ext;
        }

        public String extension(){
            int dot = fullPath.lastIndexOf(extensionSeparator);
            return fullPath.substring(dot + 1);
        }

        // gets filename without extension
        public String filename(){
            int dot = fullPath.lastIndexOf(extensionSeparator);
            int sep = fullPath.lastIndexOf(pathSeparator);
            return fullPath.substring(sep + 1,dot);
        }

        public String path(){
            int sep = fullPath.lastIndexOf(pathSeparator);
            return fullPath.substring(0,sep);
        }
    }

    public void stringCompare(){
        String searchMe = "Green Eggs and Ham";
        String findMe = "Eggs";
        int searchMeLength = searchMe.length();
        int findMeLength = findMe.length();
        boolean foundIt = false;

        for(int i = 0; i <= (searchMeLength - findMeLength); i++){
            if(searchMe.regionMatches(i,findMe,0,findMeLength)){
                foundIt = true;
                System.out.println(searchMe.substring(i,i + findMeLength));
                break;
            }
        }
        if(!foundIt){
            System.out.println("No match found.");
        }
    }

    public void stringBuilder(){
        String palindrome = "Dot saw I was Tod";

        StringBuilder sb = new StringBuilder(palindrome);

        sb.reverse();  // reverse it

        System.out.println(sb);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Strings s = new Strings();
        s.length();
        s.concat();
        s.format();
        s.stringsToNumbers(new String[]{"4.5","87.2"});
        s.numbersToStrings();
        s.substring();
        s.stringManip();

        final String FPATH = "/home/user/index.html";
        Strings.Filename myHomePage = s.new Filename(FPATH,'/','.');
        System.out.println("Extension = " + myHomePage.extension());
        System.out.println("Filename = " + myHomePage.filename());
        System.out.println("Path = " + myHomePage.path());

        s.stringCompare();
        s.stringBuilder();
    }
}
