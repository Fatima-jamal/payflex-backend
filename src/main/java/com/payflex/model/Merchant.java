package com.payflex.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "merchants")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String mid;

    private String name;
    private String password;
    private String dba; // ✅ Add this field
    private String website;
    private String phone;
    private String email;
    private String cnic;
    private String address;
    private String city;

    @Column(name = "is_approved")
    private boolean isApproved;

    @Column(name = "is_rejected")
    private boolean isRejected;

    private String rejectionReason;
}
