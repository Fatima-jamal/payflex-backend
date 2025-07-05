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
    private String dba;
    private String email;
    private String proprietorCnic;
    private String mobileNumber;
    private String merchantCategory;
    private String merchantType;
    private String cnicExpiry;
    private String city;
    private String region;
    private String businessAddress;
    private String revenue;
    private String password;

    @Column(name = "is_approved")
    private boolean isApproved;
}
