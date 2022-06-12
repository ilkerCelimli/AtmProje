package com.portifolyo.atmproject.services.impl;

import com.portifolyo.atmproject.entities.User;
import com.portifolyo.atmproject.repositories.UserRepository;
import com.portifolyo.atmproject.services.UserService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public void RegisterUser(User user) throws SQLException {
        Optional<User> e = userRepository.findUserByEmailEquals(user.getEmail());
        if(e.isEmpty()) {
            super.addEntity(user);
        }
    }

    @Override
    public void resetPassword(String email) throws SQLException {

    }


}
