package com.mycomp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@Entity(name = "paymentDetails")
public class PaymentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal merchantPayoutAmount;
    private BigDecimal commissionAmount;
    @Column(columnDefinition = "DATE")
    private LocalDate payoutDate;

    @OneToOne(mappedBy = "paymentDetail",cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")//no need to add, because this is default name
    private Payment payment;

    public PaymentDetail(BigDecimal merchantPayoutAmount, BigDecimal commissionAmount, LocalDate payoutDate) {
        this.merchantPayoutAmount = merchantPayoutAmount;
        this.commissionAmount = commissionAmount;
        this.payoutDate = payoutDate;
    }
}
