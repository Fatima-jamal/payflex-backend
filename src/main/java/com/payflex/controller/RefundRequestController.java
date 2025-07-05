package com.payflex.controller;

import com.payflex.model.RefundRequest;
import com.payflex.service.RefundRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/refunds")
@CrossOrigin(origins = "*")
public class RefundRequestController {

    @Autowired
    private RefundRequestService refundRequestService;

    @PostMapping
    public ResponseEntity<RefundRequest> submitRefund(@RequestBody RefundRequest refundRequest) {
        RefundRequest savedRequest = refundRequestService.saveRefundRequest(refundRequest);
        return ResponseEntity.ok(savedRequest);
    }

    @GetMapping("/{merchantId}")
    public ResponseEntity<List<RefundRequest>> getRefunds(@PathVariable String merchantId) {
        return ResponseEntity.ok(refundRequestService.getRefundsByMerchant(merchantId));
    }
}
