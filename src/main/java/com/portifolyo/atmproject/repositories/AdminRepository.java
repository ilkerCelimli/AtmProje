package com.portifolyo.atmproject.repositories;

import com.portifolyo.atmproject.entities.Admin;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdminRepository extends BaseRepository<Admin> {
    @Query("select (count(a) > 0) from Admin a where a.user.email = ?1")
    boolean CheckEmail(String email);




}
