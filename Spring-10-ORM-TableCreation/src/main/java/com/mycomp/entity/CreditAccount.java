package com.mycomp.entity;

import javax.persistence.Entity;
import javax.swing.text.Position;
import java.math.BigDecimal;
@Entity
public class CreditAccount extends Account{
    private BigDecimal creditLimit;
}
