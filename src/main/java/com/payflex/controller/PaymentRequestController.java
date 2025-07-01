package com.payflex.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.payflex.model.PaymentRequest;
import com.payflex.service.PaymentRequestService;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin(origins = {
    "http://localhost:5173",
    "https://pos-tattoo-imports-studying.trycloudflare.com"
})
@RestController
@RequestMapping("/api/payment-requests")
public class PaymentRequestController {

    @Autowired
    private PaymentRequestService paymentRequestService;

    @PostMapping
    public ResponseEntity<String> createPaymentRequest(@RequestBody PaymentRequest paymentRequest) {
        System.out.println("Received payment: " + paymentRequest); // Optional debug log
        paymentRequestService.savePaymentRequest(paymentRequest);
        return ResponseEntity.ok("Payment saved successfully");
    }

    @GetMapping
    public List<PaymentRequest> getAllPaymentRequests() {
        return paymentRequestService.getAllRequests();
    }
}
