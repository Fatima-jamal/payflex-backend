package com.payflex.controller;

import com.payflex.model.Merchant;
import com.payflex.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/merchants")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MerchantController {

    @Autowired
    private MerchantRepository merchantRepository;

    // Submit new merchant
    @PostMapping("/submit")
    public ResponseEntity<String> submitMerchant(@RequestBody Merchant merchant) {
        merchant.setApproved(false);
        if (merchant.getMid() == null || merchant.getMid().isEmpty()) {
            merchant.setMid(generateMid());
        }
        merchantRepository.save(merchant);
        return ResponseEntity.ok("Merchant submitted successfully.");
    }

    // Approve merchant
    @PutMapping("/approve/{mid}")
    public ResponseEntity<String> approveMerchant(@PathVariable String mid) {
        Merchant merchant = merchantRepository.findByMid(mid);
        if (merchant == null) {
            return ResponseEntity.status(404).body("Merchant not found");
        }

        merchant.setApproved(true);
        if (merchant.getPassword() == null || merchant.getPassword().isEmpty()) {
            merchant.setPassword(generatePassword());
        }

        merchantRepository.save(merchant);
        return ResponseEntity.ok("Merchant approved");
    }

    // Reject merchant
    @DeleteMapping("/reject/{mid}")
    public ResponseEntity<String> rejectMerchant(@PathVariable String mid) {
        Merchant merchant = merchantRepository.findByMid(mid);
        if (merchant == null) {
            return ResponseEntity.status(404).body("Merchant not found");
        }

        merchantRepository.delete(merchant);
        return ResponseEntity.ok("Merchant rejected and deleted");
    }

    // Get merchant by MID
    @GetMapping("/{mid}")
    public ResponseEntity<?> getMerchantByMid(@PathVariable String mid) {
        Merchant merchant = merchantRepository.findByMid(mid);
        if (merchant != null) {
            return ResponseEntity.ok(merchant);
        } else {
            return ResponseEntity.status(404).body("Merchant not found");
        }
    }

    // Get pending merchants
    @GetMapping("/pending")
    public ResponseEntity<List<Merchant>> getPendingMerchants() {
        return ResponseEntity.ok(merchantRepository.findByIsApprovedFalse());
    }

    // Get approved merchants
    @GetMapping("/approved")
    public ResponseEntity<List<Merchant>> getApprovedMerchants() {
        return ResponseEntity.ok(merchantRepository.findByIsApprovedTrue());
    }

    private String generateMid() {
        return "9202" + UUID.randomUUID().toString().substring(0, 10).replace("-", "");
    }

    private String generatePassword() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
