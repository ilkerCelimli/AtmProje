package com.portifolyo.atmproject.api.v1;

import com.portifolyo.atmproject.annotation.Validate;
import com.portifolyo.atmproject.entities.dto.AdminRegisterDto;
import com.portifolyo.atmproject.enums.Validations;
import com.portifolyo.atmproject.services.AdminService;
import com.portifolyo.atmproject.utils.dtoconverters.AdminRegisterDtoConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

import static com.portifolyo.atmproject.api.Constants.API_BASE_URL;

@RestController
@RequestMapping(API_BASE_URL + "admin")
public class AdminApi {


    private final AdminService adminService;
    private final AdminRegisterDtoConverter adminRegisterDtoConverter;
    public boolean isChecked = true;

    public AdminApi(AdminService adminServiceImpl, AdminRegisterDtoConverter adminRegisterDtoConverter) {
        this.adminService = adminServiceImpl;
        this.adminRegisterDtoConverter = adminRegisterDtoConverter;
    }

    @PostMapping("/registerAdmin")
    @Validate(validator = Validations.ADMIN_REGISTER)
    public ResponseEntity<String> registerAdmin(@RequestBody AdminRegisterDto adminRegisterDto) throws SQLException {

        try {
            boolean result = adminService.CheckAdmin(adminRegisterDto.getUserRegisterDto().getEmail());
            if (!isChecked) {
                throw new Exception("Doğrulama hatası");
            } else if (!result) {
                this.adminService.addEntity(adminRegisterDtoConverter.ToEntity(adminRegisterDto));
                return ResponseEntity.created(null).build();
            }
            else throw new Exception("Email sistemde mevcut.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}

