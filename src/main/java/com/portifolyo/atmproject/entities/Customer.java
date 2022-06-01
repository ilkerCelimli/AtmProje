package com.portifolyo.atmproject.entities;

import com.portifolyo.atmproject.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer extends BaseEntity {

    @OneToOne
    private User user;

    @Enumerated(value = EnumType.STRING)
    @Column
    private Roles role = Roles.CUSTOMER;

    @Column
    private BigDecimal balance;
}
