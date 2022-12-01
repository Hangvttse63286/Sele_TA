package com.example.tadashboard.common.constant;

public enum AssertMessage {
    ELEMENT_NOT_DISPLAYED("This element is not existed or displayed on UI: "),
    ELEMENT_STILL_DISPLAYED("This element is still existed or displayed on UI: "),
    VALUE_MISMATCH_WITH_EXPECTED("The value of this element is not equal with expected: "),
    PAGE_NOT_DISPLAYED("This page is not displayed: "),
    ELEMENT_STILL_CLICKABLE("This element is still clickable: ");
    private final String msg;

    AssertMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
