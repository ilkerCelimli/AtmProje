package com.portifolyo.atmproject.enums;

public enum Roles {


    ADMIN("ADMIN"),
    CUSTOMER("CUSTOMER");

    String roles;


    Roles(String customer) {
        this.roles = customer;
    }
}
