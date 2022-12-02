package com.example.tadashboard.dataObjects;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ItemType {
    TEST_MODULES("Test Modules"),
    TEST_CASES("Test Cases"),
    TEST_OBJECTIVES("Test Objectives"),
    DATA_SET("Data Sets"),
    ACTIONS("Actions"),
    INTERFACE_ENTITIES("Interface Entities"),
    TEST_RESULTS("Test Results"),
    TEST_CASE_RESULTS("Test Case Results"),
    TEST_SUITES("Test Suites"),
    BUGS("Bugs");

    private final String type;

    ItemType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return type;
    }

    public static List<String> getItemTypes() {
        return Arrays.stream(ItemType.values()).map(ItemType::getType).collect(Collectors.toList());
    }
}
