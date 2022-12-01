package com.example.tadashboard.dataObjects;

public enum Message {
    LOGIN_INVALID_USER("Username or password is invalid");

    private final String msg;

    Message(String msg) {
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
