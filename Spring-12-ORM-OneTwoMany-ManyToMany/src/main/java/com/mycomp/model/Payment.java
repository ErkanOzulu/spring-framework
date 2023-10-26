package com.mycomp.model;

import com.mycomp.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@Entity(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "DATE")
    private LocalDate createDate;
    private BigDecimal amount;
    private Status paymentStatus;
    @OneToOne(cascade=CascadeType.ALL)
    private PaymentDetail paymentDetail;

    public Payment(LocalDate createDate, BigDecimal amount, Status paymentStatus) {
        this.createDate = createDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }
}
