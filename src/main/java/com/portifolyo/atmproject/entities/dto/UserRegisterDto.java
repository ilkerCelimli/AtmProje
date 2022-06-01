package com.portifolyo.atmproject.entities.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserRegisterDto {

    private String name;
    private String surname;
    private String email;
    private String password;
    private Date birtday;
    private String secretQuestion;
    private String secretAnswer;
}
