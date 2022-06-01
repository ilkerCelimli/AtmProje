package com.portifolyo.atmproject.services.impl;

import com.portifolyo.atmproject.annotation.Log;
import com.portifolyo.atmproject.entities.BaseEntity;
import com.portifolyo.atmproject.repositories.BaseRepository;
import com.portifolyo.atmproject.services.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    private final BaseRepository<T> repository;

    @Override
    @Log(log = "Kayıt oluşturuldu")
    @Transactional
    public void addEntity(T e) throws SQLException {
        T temp = repository.save(e);
        if(temp.getId() == null) {
            throw new SQLException("Sql Hata.");
        }
    }


    @Override
    @Log(log = "Kayıt güncellendi")
    @Transactional
    public void updateEntity(T e) throws SQLException {
        Date date = new Date();
        e.setUpdatedDate(date);
        T temp = repository.save(e);
        if(!temp.getUpdatedDate().equals(date)) {
            throw new SQLException("Sql hata");
        }

    }

    @Override
    @Log(log = "Kayıt silindi")
    @Transactional
    public void deleteEntityById(String id) throws ClassNotFoundException, SQLException {
        T temp = findById(id);
        repository.delete(temp);
      boolean t =  repository.findById(id).isEmpty();
       if(t) {
           return;
       }
       else throw new SQLException();
    }

    @Override
    @Log(log ="Veritabanından Sıralı veriler çekildi. {}")
    @Transactional(readOnly = true)
    public List<T> findAll(String sortBy) {
       return repository.findAll(Sort.by(sortBy).descending());



    }

    @Override
    @Log(log = "id'den çekildi {}" )
    @Transactional(readOnly = true)
    public T findById(String id) throws ClassNotFoundException {
        Optional<T> o = repository.findById(id);
        if(o.isPresent()) {
            return o.get();
        }
        else throw new ClassNotFoundException("Kayıt bulunamadı");
    }

    @Override
    @Log(log = "Sayfa olarak veritabanından çekildi.")
    @Transactional(readOnly = true)
    public Page<T> listByPage(Pageable p) {
        return this.repository.findAll(p);
    }
}
