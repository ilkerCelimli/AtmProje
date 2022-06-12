package com.portifolyo.atmproject.entities.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class SendMoneyDto implements Serializable {
    private final String id;
    private final BigDecimal balance;
    private final String descr;
}
