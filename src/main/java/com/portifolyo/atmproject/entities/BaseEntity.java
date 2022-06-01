package com.portifolyo.atmproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseEntity {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date createdDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date updatedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date deletedDate;

    @Column
    private Boolean isDeleted = false;
}
