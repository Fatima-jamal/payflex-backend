package com.payflex.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transactions")  // Make sure this matches your DB table name
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "tid")
    private String tid;

    @Column(name = "mid")
    private String mid;

    @Column(name = "merchant_id")
    private String merchantId;

    @Column(name = "status")
    private String status;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "paid_amount")
    private Double paidAmount;

    @Column(name = "created_at")
    private String createdAt; // Optional: can be LocalDateTime if DB supports timestamp
}
