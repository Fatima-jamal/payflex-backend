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

    public void savePaymentRequest(PaymentRequest paymentRequest) {
        paymentRequestRepository.save(paymentRequest);
    }

    public List<PaymentRequest> getAllRequests() {
        return paymentRequestRepository.findAll();
    }
}
