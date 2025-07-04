package com.payflex.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.payflex.model.PaymentRequest;
import com.payflex.service.PaymentRequestService;
import org.springframework.http.ResponseEntity;
import java.util.List;

@CrossOrigin(origins = {
    "http://localhost:5173",
    "https://pos-tattoo-imports-studying.trycloudflare.com",
    "https://payflex-app.fatima-jamal.com",
    "https://payflex-frontend.netlify.app"
})
@RestController
@RequestMapping("/api/payment-requests")
public class PaymentRequestController {

    @Autowired
    private PaymentRequestService paymentRequestService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<PaymentResponse> createPaymentRequest(@RequestBody PaymentRequest paymentRequest) {
        System.out.println("===== Payment Received =====");
        System.out.println("Merchant ID: " + paymentRequest.getMerchantId());
        System.out.println("Customer Name: " + paymentRequest.getCustomerName());
        System.out.println("Email: " + paymentRequest.getEmail());
        System.out.println("Phone: " + paymentRequest.getPhone());
        System.out.println("Amount: " + paymentRequest.getAmount());
        System.out.println("Description: " + paymentRequest.getDescription());
        System.out.println("=============================");

        PaymentRequest saved = paymentRequestService.savePaymentRequest(paymentRequest);
        return ResponseEntity.ok(new PaymentResponse(saved.getId()));
    }

    @GetMapping
    public List<PaymentRequest> getAllPaymentRequests() {
        return paymentRequestService.getAllRequests();
    }

    public static class PaymentResponse {
        private Long id;

        public PaymentResponse(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
}
