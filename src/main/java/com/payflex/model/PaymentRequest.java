package com.payflex.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payment_requests")
public class PaymentRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerEmail;

    private BigDecimal amount;

    private LocalDate dueDate;

    private String status; // PENDING, CONFIRMED, FAILED

    // --- Constructors ---
    public PaymentRequest() {}

    public PaymentRequest(String customerEmail, BigDecimal amount, LocalDate dueDate, String status) {
        this.customerEmail = customerEmail;
        this.amount = amount;
        this.dueDate = dueDate;
        this.status = status;
    }

    // --- Getters ---
    public Long getId() {
        return id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }

    // --- Setters ---
    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
