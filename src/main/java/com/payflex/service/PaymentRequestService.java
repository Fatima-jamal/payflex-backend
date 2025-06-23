package com.payflex.service;

import com.payflex.model.PaymentRequest;
import com.payflex.repository.PaymentRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentRequestService {
    private final PaymentRequestRepository repository;

    public PaymentRequestService(PaymentRequestRepository repository) {
        this.repository = repository;
    }

    public List<PaymentRequest> getAll() {
        return repository.findAll();
    }

    public PaymentRequest create(PaymentRequest request) {
        return repository.save(request);
    }

    public PaymentRequest getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public PaymentRequest update(Long id, PaymentRequest updated) {
        updated.setId(id);
        return repository.save(updated);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
