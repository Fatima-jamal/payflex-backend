package com.payflex.repository;

import com.payflex.model.PaymentRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRequestRepository extends JpaRepository<PaymentRequest, Long> {
}
