package com.portifolyo.atmproject.repositories.projections;

import java.util.Date;

public interface UserInfo {
    String getId();

    Date getCreatedDate();

    Date getUpdatedDate();

    boolean isDeleted();

    String getName();

    String getSurname();

    String getEmail();

    Date getBirtday();
}
