package com.payflex.controller;

import com.payflex.dto.RefundRequestDTO;
import com.payflex.model.RefundRequest;
import com.payflex.repository.RefundRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/refunds")
@CrossOrigin
public class RefundRequestController {

    @Autowired
    private RefundRequestRepository repository;

    @PostMapping
    public ResponseEntity<String> createRefund(@RequestBody RefundRequestDTO dto) {
        RefundRequest refund = new RefundRequest();

        // Fix: Convert Strings to Integer
        refund.setMerchantId(Integer.parseInt(dto.getMerchantId()));
        refund.setTransactionId(Integer.parseInt(dto.getTransactionId()));

        refund.setReason(dto.getReason());
        refund.setAmount(dto.getAmount());
        refund.setStatus("PENDING");

        repository.save(refund);
        return ResponseEntity.ok("Refund saved successfully.");
    }

    @GetMapping
    public ResponseEntity<List<RefundRequest>> getRefundsByMerchantId(@RequestParam Integer merchantId) {
        List<RefundRequest> refunds = repository.findByMerchantId(merchantId);
        return ResponseEntity.ok(refunds);
    }
}
