package com.example.demo.service;

public class ResponseMessage {
    private String value;

    public ResponseMessage(String value) {
        this.value = value;
    }

    // getters and setters
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}