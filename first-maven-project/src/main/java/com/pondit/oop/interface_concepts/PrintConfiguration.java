package com.pondit.oop.interface_concepts;

public interface PrintConfiguration {
    String getColorMode();
}

class PhotoPrintConfiguration implements PrintConfiguration {
    private Double width;
    private Double height;
    private String colorMode;

    public void setWidth(Double width) {
        this.width = width;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setColorMode(String colorMode) {
        this.colorMode = colorMode;
    }

    @Override
    public String getColorMode() {
        return this.colorMode;
    }

    Double photoWidth() {
        return this.width;
    }
    Double photoHeight() {
        return this.height;
    }
}

class DocumentPrintConfiguration implements PrintConfiguration {

    private String pageLayout;
    private String pageSize;
    private String colorMode;

    String pageLayout() {
        return this.pageLayout;
    }
    String pageSize() {
        return this.pageSize;
    }

    public void setPageLayout(String pageLayout) {
        this.pageLayout = pageLayout;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public void setColorMode(String colorMode) {
        this.colorMode = colorMode;
    }

    @Override
    public String getColorMode() {
        return this.colorMode;
    }
}