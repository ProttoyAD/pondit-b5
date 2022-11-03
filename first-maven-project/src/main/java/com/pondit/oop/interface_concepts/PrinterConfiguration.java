package com.pondit.oop.interface_concepts;

public interface PrinterConfiguration {

    String getPrinterName();
    String getPrinterModel();
}

class HpPrinterConfig implements PrinterConfiguration {
    private String printerName;
    private String printerModel;

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public void setPrinterModel(String printerModel) {
        this.printerModel = printerModel;
    }

    @Override
    public String getPrinterName() {
        return this.printerName;
    }

    @Override
    public String getPrinterModel() {
        return this.printerModel;
    }
}

class CanonPrinterConfig implements PrinterConfiguration {
    private String printerName;
    private String printerModel;

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public void setPrinterModel(String printerModel) {
        this.printerModel = printerModel;
    }

    @Override
    public String getPrinterName() {
        return this.printerName;
    }

    @Override
    public String getPrinterModel() {
        return this.printerModel;
    }
}