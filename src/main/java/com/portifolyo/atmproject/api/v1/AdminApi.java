package com.portifolyo.atmproject.api.v1;

import com.portifolyo.atmproject.annotation.Validate;
import com.portifolyo.atmproject.entities.dto.AdminRegisterDto;
import com.portifolyo.atmproject.enums.Validations;
import com.portifolyo.atmproject.repositories.projections.CustomerInfo;
import com.portifolyo.atmproject.services.AdminService;
import com.portifolyo.atmproject.utils.dtoconverters.AdminRegisterDtoConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

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
            boolean result = adminService.checkAdmin(adminRegisterDto.getUserRegisterDto().getEmail());
            if (!isChecked) {
                throw new SQLException("Doğrulama hatası");
            } else if (!result) {
                this.adminService.addEntity(adminRegisterDtoConverter.ToEntity(adminRegisterDto));
                return ResponseEntity.created(null).build();
            }
            else throw new SQLException("Email sistemde mevcut.");
        } catch (SQLException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/findCustoemers")
    public ResponseEntity<List<CustomerInfo>> findByCustomers() {
        return ResponseEntity.ok(this.adminService.findByCustomers());
    }
}

