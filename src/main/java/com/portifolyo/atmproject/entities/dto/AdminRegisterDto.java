package com.portifolyo.atmproject.entities.dto;

import com.portifolyo.atmproject.enums.Roles;
import lombok.Data;

@Data
public class AdminRegisterDto {



    private Roles roles;
    private UserRegisterDto userRegisterDto;

}
