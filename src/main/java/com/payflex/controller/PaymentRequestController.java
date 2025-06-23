package com.payflex.controller;

import com.payflex.model.PaymentRequest;
import com.payflex.service.PaymentRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-requests")
public class PaymentRequestController {
    private final PaymentRequestService service;

    public PaymentRequestController(PaymentRequestService service) {
        this.service = service;
    }

    @GetMapping
    public List<PaymentRequest> getAll() {
        return service.getAll();
    }

    @PostMapping
    public PaymentRequest create(@RequestBody PaymentRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public PaymentRequest getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public PaymentRequest update(@PathVariable Long id, @RequestBody PaymentRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
