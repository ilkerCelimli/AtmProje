package com.portifolyo.atmproject.utils.dtoconverters;

import com.portifolyo.atmproject.entities.Admin;
import com.portifolyo.atmproject.entities.User;
import com.portifolyo.atmproject.entities.dto.AdminRegisterDto;
import org.springframework.stereotype.Component;

@Component
public class AdminRegisterDtoConverter {

    public Admin ToEntity(AdminRegisterDto dto) {

        Admin admin = new Admin();
        admin.setRole(dto.getRoles());
        User user = new User();
        user.setName(dto.getUserRegisterDto().getName());
        user.setSurname(dto.getUserRegisterDto().getSurname());
        user.setBirtday(dto.getUserRegisterDto().getBirtday());
        user.setEmail(dto.getUserRegisterDto().getEmail());
        user.setPassword(dto.getUserRegisterDto().getPassword());
        user.setSecretAnswer(dto.getUserRegisterDto().getSecretAnswer());
        user.setSecretQuestion(dto.getUserRegisterDto().getSecretQuestion());
        user.setIsDeleted(false);
        admin.setUser(user);
        return admin;
    }

}
