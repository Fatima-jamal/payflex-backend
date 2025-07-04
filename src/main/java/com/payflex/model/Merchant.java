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
    private String dbaName;
    private String website;
    private String phone;

    @Column(name = "is_approved")
    private boolean isApproved;

    // If you prefer explicit getters/setters, replace @Data and use below:
    // public boolean isApproved() { return isApproved; }
    // public void setApproved(boolean approved) { isApproved = approved; }
}
