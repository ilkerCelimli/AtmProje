package com.portifolyo.atmproject.enums;

public enum Transactions {


    SEND("SEND"),
    ACCEPT("ACCEPT");

    String text;
    Transactions(String text) {
        this.text = text;
    }
}
