package com.portifolyo.atmproject.repositories.projections;

import com.portifolyo.atmproject.enums.Roles;

import java.math.BigDecimal;
import java.util.Date;

public interface CustomerInfo {
    Roles getRole();

    BigDecimal getBalance();

    UserInfo getUser();

    interface UserInfo {
        String getId();

        Date getCreatedDate();

        Date getUpdatedDate();

        String getName();

        String getSurname();

        String getEmail();

        String getSecretQuestion();

        Date getBirtday();
    }
}
