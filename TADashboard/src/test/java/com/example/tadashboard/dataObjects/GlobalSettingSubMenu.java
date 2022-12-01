package com.example.tadashboard.dataObjects;

public enum GlobalSettingSubMenu {
    ADD_PAGE("Add Page"),
    CREATE_PROFILE("Create Profile"),
    CREATE_PANEL("Create Panel"),
    EDIT("Edit"),
    DELETE("Delete");

    private final String tab;

    GlobalSettingSubMenu(String tab) {
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
