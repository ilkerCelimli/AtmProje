package com.portifolyo.atmproject.services;

import com.portifolyo.atmproject.entities.User;

import java.sql.SQLException;

public interface UserService extends BaseService<User> {

    void RegisterUser(User user) throws SQLException;
    void resetPassword(String email) throws SQLException;




}
