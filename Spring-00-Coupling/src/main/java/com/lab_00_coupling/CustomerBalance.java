package com.lab_00_coupling;

import com.lab_00_coupling.loosely.Balance;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class CustomerBalance extends Balance {

    public CustomerBalance(UUID userId, BigDecimal amount) {
        super(userId,amount);
    }

    public BigDecimal addBalance(BigDecimal amount) {
        setAmount(this.getAmount().add(amount));
        return this.getAmount();
    }
}