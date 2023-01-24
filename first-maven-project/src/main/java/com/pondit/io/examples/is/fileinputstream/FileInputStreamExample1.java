package com.pondit.io.examples.is.fileinputstream;

import java.io.*;
import java.util.stream.Stream;

public class FileInputStreamExample1 {

    public static void main(String[] args) throws IOException {
        File file = new File(System.getProperty("user.home") + "\\Desktop\\testout.txt");
        // With FileInputStream
        FileInputStream fis = new FileInputStream(file);
        int b = 0;
        while ((b = fis.read()) != -1) {
            System.out.print((char) b);
        }
        System.out.println("\n======================================");

        // With FileReader
        FileReader fr = new FileReader(file);
        b = 0;
        while ((b = fr.read()) != -1) {
            System.out.print((char) b);
        }
        System.out.println("\n======================================");

        // With BufferedReader wrapping FileInputStream
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line = "";
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println("======================================");

        // With BufferedReader wrapping FileReader
        br = new BufferedReader(new FileReader(file));
        line = "";
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        System.out.println("======================================");

        System.out.println("==================== Processing with Stream API =======================");
        Stream.of(new FileInputStream(file).readAllBytes()).map(bytes -> {
            String s = "";
            for (byte byt : bytes) {
                s += (char)byt;
            }
            return s;
        }).forEach(System.out::println);
    }
}
