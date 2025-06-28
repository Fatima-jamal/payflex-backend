package com.payflex.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.payflex.model.PaymentRequest;
import com.payflex.service.PaymentRequestService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/payment-requests")
public class PaymentRequestController {

    @Autowired
    private PaymentRequestService paymentRequestService;

    @PostMapping
    public void createPaymentRequest(@RequestBody PaymentRequest paymentRequest) {
        paymentRequestService.savePaymentRequest(paymentRequest);
    }

    @GetMapping
    public List<PaymentRequest> getAllPaymentRequests() {
        return paymentRequestService.getAllRequests();
    }
}
