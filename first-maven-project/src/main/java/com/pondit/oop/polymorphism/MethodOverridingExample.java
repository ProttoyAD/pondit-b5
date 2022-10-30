package com.pondit.oop.polymorphism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class Printer {
    public abstract void print();
}

class PhotoPrinter extends Printer {

    @Override
    public void print() {
        System.out.println("Photo printing with a photo printer");
    }
}

class DocumentPrinter extends Printer {

    @Override
    public void print() {
        System.out.println("Document printing with a document printer");
    }
}

class PlotterPrinter extends Printer {

    @Override
    public void print() {
        System.out.println("Map printing with a plotter printer");
    }
}

public class MethodOverridingExample {

    public static void main(String[] args) throws IOException {
        Printer printer;
        String printingType;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while ((printingType = br.readLine()) != null) {
            switch (printingType) {
                case "document" -> {
                    printer = new DocumentPrinter();
                    printer.print();
                }
                case "photo" -> {
                    printer = new PhotoPrinter();
                    printer.print();
                }
                case "plotter" -> {
                    printer = new PlotterPrinter();
                    printer.print();
                }
                default -> System.err.println("Cannot find a printer");
            }
        }
    }
}
