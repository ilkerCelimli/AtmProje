package com.portifolyo.atmproject.repositories;

import com.portifolyo.atmproject.entities.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {

    Optional<User> findUserByEmailEquals(String emai);

}
