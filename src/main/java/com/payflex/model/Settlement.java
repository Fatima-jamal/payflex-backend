package com.payflex.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "settlements")
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mid;

    @Column(name = "settlement_date")
    private String settlementDate;

    @Column(name = "total_amount")
    private int totalAmount;

    @Column(name = "reference_id")
    private String referenceId;

    private String status;
}
