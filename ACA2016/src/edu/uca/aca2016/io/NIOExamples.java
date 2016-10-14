/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author cfiles
 */
public class NIOExamples{

    public void checkFile() throws IOException{
        Path inpath = Paths.get("resources","io","xanadu.txt");
        Path outpath = Paths.get("resources","io","usnumbers.txt");

        System.out.println("Regular File: " + Files.isRegularFile(inpath));
        System.out.println("Readable File: " + Files.isReadable(inpath));
        System.out.println("Executable File: " + Files.isExecutable(inpath));
        System.out.println("Same File: " + Files.isSameFile(inpath,outpath));
    }

    public void copyFile() throws IOException{
        Path source = Paths.get("resources","io","xanadu.txt");
        Path target = Paths.get("resources","io","tmp.txt");

        Files.copy(source,target,REPLACE_EXISTING);
    }

    public void moveFile() throws IOException{
        Path source = Paths.get("resources","io","tmp.txt");
        Path target = Paths.get("resources","io","tmp2.txt");

        Files.move(source,target,REPLACE_EXISTING);
    }

    public void deleteFile() throws IOException{
        Path target = Paths.get("resources","io","tmp2.txt");

        Files.delete(target);
    }

    public void fileMeta() throws IOException{
        Path file = Paths.get("resources","io","xanadu.txt");
        BasicFileAttributes attr = Files.readAttributes(file,BasicFileAttributes.class);

        System.out.println("creationTime: " + attr.creationTime());
        System.out.println("lastAccessTime: " + attr.lastAccessTime());
        System.out.println("lastModifiedTime: " + attr.lastModifiedTime());
        System.out.println("isDirectory: " + attr.isDirectory());
        System.out.println("isOther: " + attr.isOther());
        System.out.println("isRegularFile: " + attr.isRegularFile());
        System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
        System.out.println("size: " + attr.size());
    }

    public void readFileBytes() throws IOException{
        Path file = Paths.get("resources","io","xanadu.txt");
        byte[] fileArray;
        fileArray = Files.readAllBytes(file);

        String str = new String(fileArray);

        System.out.print(str);
    }

    public void readFileBuffer() throws IOException{
        Path file = Paths.get("resources","io","xanadu.txt");

        Charset charset = Charset.forName("US-ASCII");
        BufferedReader reader = Files.newBufferedReader(file,charset);

        String line = null;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
    }

    public void createTmpFile() throws IOException{
        Path tempFile = Files.createTempFile(null,".myapp");
        System.out.format("The temporary file has been created: %s%n",tempFile);
    }

    public void listFilesInDir() throws IOException{
        Path dir = Paths.get("resources","io");
        DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
        for(Path file : stream){
            System.out.println(file.getFileName());
        }
    }
    
    public void globFilesInDir() throws IOException{
        Path dir = Paths.get("resources","io");
        DirectoryStream<Path> stream = Files.newDirectoryStream(dir,"us*");
        for(Path file : stream){
            System.out.println(file.getFileName());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        NIOExamples nio = new NIOExamples();
        nio.checkFile();
        nio.copyFile();
        nio.moveFile();
        nio.deleteFile();
        nio.fileMeta();
        nio.readFileBytes();
        nio.readFileBuffer();
        nio.createTmpFile();
        nio.listFilesInDir();
        nio.globFilesInDir();
    }

}
