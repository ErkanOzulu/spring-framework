package com.lab_00_coupling.loosely;

import java.math.BigDecimal;

public class BalanceManager {
    public boolean checkout(Balance balance, BigDecimal checkoutAmount){
        BigDecimal balanceAmount = balance.getAmount();

        return balanceAmount.subtract(checkoutAmount) //YourBalance - What you are trying to buy
                .compareTo(BigDecimal.ZERO) >= 0; //1 0 -1
        //100 -140 = -40
    }
}