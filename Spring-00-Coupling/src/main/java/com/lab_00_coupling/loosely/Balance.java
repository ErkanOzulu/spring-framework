package com.lab_00_coupling.loosely;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public abstract class Balance {
    private UUID userId;
    private BigDecimal amount;

    public abstract BigDecimal addBalance(BigDecimal amount);

}