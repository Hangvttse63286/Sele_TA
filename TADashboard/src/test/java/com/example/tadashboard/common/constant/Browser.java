package com.example.tadashboard.common.constant;

import java.util.Arrays;

public enum Browser {
    CHROME,
    FIREFOX;

    public static Browser fromString(String s) throws IllegalArgumentException {
        return Arrays.stream(Browser.values())
                .filter(v -> v.name().equalsIgnoreCase(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown value: " + s));
    }
}
