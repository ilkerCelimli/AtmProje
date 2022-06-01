package com.portifolyo.atmproject.entities;

import com.portifolyo.atmproject.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends BaseEntity {


    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @Enumerated(value = EnumType.STRING)
    @Column
    private Roles role = Roles.ADMIN;


}
