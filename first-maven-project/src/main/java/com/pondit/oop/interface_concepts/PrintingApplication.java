package com.pondit.oop.interface_concepts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintingApplication {
    public static void main(String[] args) throws IOException {
        var printerConfiguration = new CanonPrinterConfig();
        printerConfiguration.setPrinterName("Canon");
        printerConfiguration.setPrinterModel("L360");

        var photoPrintConfig = new PhotoPrintConfiguration();
        photoPrintConfig.setHeight(4.0);
        photoPrintConfig.setWidth(4.0);
        photoPrintConfig.setColorMode("RGB");

        var documentPrintConfig = new DocumentPrintConfiguration();
        documentPrintConfig.setColorMode("CMYK");
        documentPrintConfig.setPageSize("A4");
        documentPrintConfig.setPageLayout("Portrait");

        MyPrinter printer = new MyPrinter();
        printer.connectPrinter(printerConfiguration);
        printer.print(photoPrintConfig);
        printer.print(documentPrintConfig);
    }
}

class MyPrinter extends AbstractPrinter {

    @Override
    public void print(PrintConfiguration printConfiguration) {
        Printer printer;
        if (printConfiguration instanceof PhotoPrintConfiguration) {
            printer = new PhotoPrinter();
            printer.print(printConfiguration);
        } else if (printConfiguration instanceof DocumentPrintConfiguration) {
            printer = new DocumentPrinter();
            printer.print(printConfiguration);
        }
    }
}
