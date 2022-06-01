package com.portifolyo.atmproject.services;

import com.portifolyo.atmproject.entities.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.SQLException;
import java.util.List;

public interface BaseService<T extends BaseEntity> {

    void addEntity(T e) throws SQLException;
    void updateEntity(T e) throws SQLException;
    void deleteEntityById(String id) throws ClassNotFoundException, SQLException;
    List<T> findAll(String sortedBy);
    T findById(String id) throws ClassNotFoundException;
    Page listByPage(Pageable p);
}
