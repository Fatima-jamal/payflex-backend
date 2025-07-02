package com.payflex.service;

import com.payflex.model.PaymentRequest;
import com.payflex.repository.PaymentRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentRequestService {

    @Autowired
    private PaymentRequestRepository paymentRequestRepository;

    // ✅ Now returns the saved request (with generated ID)
    public PaymentRequest savePaymentRequest(PaymentRequest paymentRequest) {
        return paymentRequestRepository.save(paymentRequest);
    }

    public List<PaymentRequest> getAllRequests() {
        return paymentRequestRepository.findAll();
    }
}
