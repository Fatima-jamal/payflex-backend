package com.payflex.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transactions") // Must match the actual table name in PostgreSQL
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "merchant_id") // This must match column in DB for queries like findByMerchantId()
    private String merchantId;

    @Column(name = "mid") // If this is used for merchant profile display, keep it
    private String mid;

    @Column(name = "status")
    private String status;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "paid_amount")
    private Double paidAmount;

    // Optional: add timestamp if needed for future sorting/filtering
    // @Column(name = "created_at")
    // private LocalDateTime createdAt;
}
