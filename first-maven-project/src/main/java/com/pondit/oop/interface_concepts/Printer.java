package com.pondit.oop.interface_concepts;

public interface Printer {

    void print(PrintConfiguration printConfiguration);
}

abstract class AbstractPrinter implements Printer {

    public void connectPrinter (PrinterConfiguration printerConfiguration) {
        System.out.println(" =============== The following printer is selected ============== ");
        System.out.println("Selected printer name: " + printerConfiguration.getPrinterName());
        System.out.println("Selected printer model: " + printerConfiguration.getPrinterModel());
        System.out.println(" ================================================================ ");
    }
}

class PhotoPrinter implements Printer {

    @Override
    public void print(PrintConfiguration printConfiguration) {
        var config = (PhotoPrintConfiguration)printConfiguration;
        System.out.println("============== Printing with Photo Printer =================");
        System.out.println("Photo height: "+config.photoHeight());
        System.out.println("Photo width: "+config.photoWidth());
        System.out.println("Photo color mode: "+config.getColorMode());
    }
}

class DocumentPrinter implements Printer {

    @Override
    public void print(PrintConfiguration printConfiguration) {
        var config = (DocumentPrintConfiguration)printConfiguration;
        System.out.println("============== Printing with Document Printer =================");
        System.out.println("Page Layout: "+config.pageLayout());
        System.out.println("Page size: "+config.pageSize());
        System.out.println("Photo color mode: "+config.getColorMode());
    }
}