package com.payflex.controller;

import com.payflex.model.RefundRequest;
import com.payflex.repository.RefundRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/refunds")
@CrossOrigin
public class RefundRequestController {

    @Autowired
    private RefundRequestRepository repository;

    @PostMapping
    public String createRefund(@RequestBody RefundRequest refundRequest) {
        repository.save(refundRequest);
        return "Refund saved successfully.";
    }
}
