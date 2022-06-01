package com.portifolyo.atmproject.services;

import com.portifolyo.atmproject.entities.User;
import com.portifolyo.atmproject.repositories.projections.UserInfo;

import java.sql.SQLException;
import java.util.List;

public interface UserService extends BaseService<User> {

    void RegisterUser(User user) throws SQLException;
    void resetPassword(String email) throws SQLException;




}
