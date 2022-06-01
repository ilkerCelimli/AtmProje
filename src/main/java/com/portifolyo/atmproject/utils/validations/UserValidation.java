package com.portifolyo.atmproject.utils.validations;

import com.portifolyo.atmproject.entities.dto.UserRegisterDto;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Date;
import java.util.regex.Pattern;

public class UserValidation {

    private Pattern emailRegex = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    public boolean validate(UserRegisterDto dto) {
        if (dto.getName().isEmpty() || dto.getName().isBlank() || dto.getName().length() <= 3) {
            return false;
        }
        if (dto.getSurname().isEmpty() || dto.getSurname().isBlank() || dto.getSurname().length() <= 3) {
            return false;
        }
/*        Date date = new Date();
        date.setTime(1072915200);
        if (date.before(dto.getBirtday())) {
            return false;
        }*/

       /* if (!emailRegex.matcher(dto.getEmail()).matches()) {
            return false;
        }*/

        if (dto.getSecretAnswer().isEmpty() || dto.getSecretAnswer().isBlank() || dto.getSecretQuestion().length() <= 3) {
            return false;
        }

        if(dto.getSecretQuestion().isBlank() ||dto.getSecretQuestion().isBlank() || dto.getSecretQuestion().length() <= 3) {
            return false;
        }

        if(dto.getPassword().isBlank() || dto.getPassword().isEmpty() || dto.getPassword().length() <= 6) {
            return false;
        }
        return true;

    }

}
