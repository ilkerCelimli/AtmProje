package com.portifolyo.atmproject.enums;

public enum Validations {


    ADMIN_REGISTER("adminRegisterValidation");

    String text;
    Validations(String adminValidation) {
        this.text = adminValidation;
    }

    public String getText() {
        return text;
    }
}
