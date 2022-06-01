package com.portifolyo.atmproject.repositories;

import com.portifolyo.atmproject.entities.User;
import com.portifolyo.atmproject.repositories.projections.UserInfo;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {

    Optional<User> findUserByEmailEquals(String emai);
    List<UserInfo> findByOrderByNameAsc(Sort sort);

}
