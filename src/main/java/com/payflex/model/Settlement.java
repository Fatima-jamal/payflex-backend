package com.payflex.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "settlements") // 👈 Important fix
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mid;
    private double totalAmount;
    private String status;
    private String settlementDate;
}
