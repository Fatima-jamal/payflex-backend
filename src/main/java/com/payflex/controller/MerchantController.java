package com.payflex.controller;

import com.payflex.model.RefundRequest;
import com.payflex.repository.RefundRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MerchantController {

    @Autowired
    private RefundRequestRepository refundRequestRepository;

    @GetMapping("/merchant-dashboard")
    public ResponseEntity<Map<String, Object>> getMerchantDashboard() {
        Map<String, Object> dashboardData = new HashMap<>();
        dashboardData.put("totalTransactions", 1519);
        dashboardData.put("totalVolume", 25641520.93);
        dashboardData.put("amountPaid", 924129.26);
        dashboardData.put("successfulTransactions", 1519);
        return ResponseEntity.ok(dashboardData);
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("Server is up and running!");
    }

    @PostMapping("/refund-request")
    public ResponseEntity<String> submitRefundRequest(@RequestBody RefundRequest request) {
        request.setStatus("Pending");
        refundRequestRepository.save(request);
        return ResponseEntity.ok("Refund request submitted successfully.");
    }
}
