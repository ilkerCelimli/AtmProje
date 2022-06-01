package com.portifolyo.atmproject.repositories.projections;

import com.portifolyo.atmproject.enums.Roles;

import java.math.BigDecimal;
import java.util.Date;

public interface CustomerInfo {
    String getId();

    Date getCreatedDate();

    Date getUpdatedDate();

    Date getDeletedDate();

    Boolean isIsDeleted();

    Roles getRole();

    BigDecimal getBalance();

    UserInfo getUser();

    interface UserInfo {
        String getId();

        String getName();

        String getSurname();

        String getEmail();

        Date getBirtday();
    }
}
