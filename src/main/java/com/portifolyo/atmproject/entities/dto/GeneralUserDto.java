package com.portifolyo.atmproject.entities.dto;

import lombok.Data;

import java.util.Date;
@Data
public class GeneralUserDto {


    private String id;
    private String email;
    private String name;
    private String surname;
    private String secretQuestion;
    private Date birtday;
    private boolean isDelete;
    private Date createdDate;
    private Date updatedDate;
    private Date deletedDate;


}
