package com.example.tadashboard.dataObjects;

public enum ChartType {
    PIE("Pie"),
    SINGLE_BAR("Single Bar"),
    STACKED_BAR("Stacked Bar"),
    GROUP_BAR("Group Bar"),
    LINE("Line");

    private final String type;

    ChartType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return type;
    }
}
