package com.example.tadashboard.dataObjects;

public enum PageTitle {
    TA_EXECUTION_DASHBOARD("TestArchitect ™ - Execution Dashboard"),
    TA_OVERVIEW("TestArchitect ™ - Overview");

    private final String title;

    PageTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}
