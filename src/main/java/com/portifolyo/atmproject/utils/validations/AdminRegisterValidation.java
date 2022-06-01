package com.portifolyo.atmproject.utils.validations;

import com.portifolyo.atmproject.entities.dto.AdminRegisterDto;
import org.springframework.stereotype.Component;

@Component
public class AdminRegisterValidation {

    public boolean validate(AdminRegisterDto dto) {


        
        UserValidation userValidation = new UserValidation();
        if(!userValidation.validate(dto.getUserRegisterDto())) {
            return false;
        }
        return true;

    }


}
