package com.portifolyo.atmproject.entities;

import com.portifolyo.atmproject.enums.Transactions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Transaction extends BaseEntity{


    @Column
    private BigDecimal total;

    @Column
    private String description;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Transactions transactions;

    @OneToOne
    private Customer sender;

    @OneToOne
    private Customer receiver;

}
