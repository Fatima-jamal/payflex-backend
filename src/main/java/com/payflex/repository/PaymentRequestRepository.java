package com.payflex.repository;

import com.payflex.model.PaymentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRequestRepository extends JpaRepository<PaymentRequest, Long> {
    List<PaymentRequest> findByMerchantId(String merchantId); // 🔁 Changed Integer → String
}
