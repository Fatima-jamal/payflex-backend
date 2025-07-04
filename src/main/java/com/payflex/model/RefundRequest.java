package com.payflex.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "refund_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefundRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "merchant_id")
    private Integer merchantId;

    @Column(name = "transaction_id")
    private Integer transactionId;

    private String reason;
    private double amount;
    private String status;
}
