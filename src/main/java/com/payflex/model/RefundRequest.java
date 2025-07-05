package com.payflex.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "refund_requests")
public class RefundRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int amount;
    private String reason;

    @Column(name = "merchant_id")
    private String merchantId;

    @Column(name = "transaction_id")
    private Long transactionId;
}
