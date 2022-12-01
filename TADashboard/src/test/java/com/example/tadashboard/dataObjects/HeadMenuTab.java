package com.example.tadashboard.dataObjects;

public enum HeadMenuTab {
    LAB_MANAGER("Lab Manager"),
    HELP("Help"),
    ADMINISTER("Administer"),
    REPOSITORY("Repository"),
    ADMINISTRATOR("administrator"),
    ADMINISTER_DATA_PROFILES("Data Profiles"),
    ADMINISTER_PANELS("Panels");

    private final String tab;

    HeadMenuTab(String tab) {
        this.tab = tab;
    }

    public String getTab() {
        return this.tab;
    }

    @Override
    public String toString() {
        return tab;
    }
}
