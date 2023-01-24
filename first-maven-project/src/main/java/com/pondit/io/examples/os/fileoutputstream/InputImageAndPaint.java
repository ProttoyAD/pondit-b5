package com.pondit.io.examples.os.fileoutputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputImageAndPaint {
    public static void main(String args[]) throws IOException, FileNotFoundException{
        try{
            var file = new File(System.getProperty("user.home") + "\\Desktop\\testout.txt");
            FileOutputStream fout=new FileOutputStream(file);
            String s="Welcome to javaTpoint.";
            byte b[]=s.getBytes();//converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("success...");
        }catch(IOException e){
            System.err.println(e);
        }
    }
}
