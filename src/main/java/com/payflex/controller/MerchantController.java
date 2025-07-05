package com.payflex.controller;

import com.payflex.model.Merchant;
import com.payflex.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/merchants")
@CrossOrigin(
    origins = "http://localhost:5175",
    allowedHeaders = "*",
    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}
)
public class MerchantController {

    @Autowired
    private MerchantRepository merchantRepository;

    @PostMapping("/submit")
    public ResponseEntity<String> submitMerchant(@RequestBody Merchant merchant) {
        merchant.setApproved(false);
        merchant.setRejected(false);
        merchant.setRejectionReason(null);

        if (merchant.getMid() == null || merchant.getMid().isEmpty()) {
            merchant.setMid(generateMid());
        }

        merchantRepository.save(merchant);
        return ResponseEntity.ok("Merchant submitted successfully.");
    }

    @PutMapping("/approve/{mid}")
    public ResponseEntity<String> approveMerchant(@PathVariable String mid) {
        Merchant merchant = merchantRepository.findByMid(mid);
        if (merchant == null) {
            return ResponseEntity.status(404).body("Merchant not found");
        }

        merchant.setApproved(true);
        merchant.setRejected(false);
        merchant.setRejectionReason(null);

        if (merchant.getPassword() == null || merchant.getPassword().isEmpty()) {
            merchant.setPassword(generatePassword());
        }

        merchantRepository.save(merchant);
        return ResponseEntity.ok("Merchant approved.");
    }

    @DeleteMapping("/reject/{mid}")
    public ResponseEntity<String> rejectMerchant(@PathVariable String mid) {
        Merchant merchant = merchantRepository.findByMid(mid);
        if (merchant == null) {
            return ResponseEntity.status(404).body("Merchant not found");
        }

        merchant.setRejected(true);
        merchant.setApproved(false);
        merchant.setRejectionReason("Incomplete or invalid information");

        merchantRepository.save(merchant);
        return ResponseEntity.ok("Merchant rejected and marked as returned.");
    }

    @PutMapping("/{id}/request-again")
    public ResponseEntity<String> requestAgain(@PathVariable Long id) {
        Merchant merchant = merchantRepository.findById(id).orElse(null);
        if (merchant == null) {
            return ResponseEntity.status(404).body("Merchant not found");
        }

        merchant.setRejected(false);
        merchant.setApproved(false);
        merchant.setRejectionReason(null);

        merchantRepository.save(merchant);
        return ResponseEntity.ok("Merchant marked for resubmission.");
    }

    @PutMapping("/{id}/reason")
    public ResponseEntity<String> updateReason(@PathVariable Long id, @RequestBody String reason) {
        Merchant merchant = merchantRepository.findById(id).orElse(null);
        if (merchant == null) {
            return ResponseEntity.status(404).body("Merchant not found");
        }

        merchant.setRejectionReason(reason);
        merchantRepository.save(merchant);
        return ResponseEntity.ok("Rejection reason updated.");
    }

    @GetMapping("/rejected")
    public ResponseEntity<List<Merchant>> getRejectedMerchants() {
        return ResponseEntity.ok(merchantRepository.findByIsRejectedTrue());
    }

    @GetMapping("/{mid}")
    public ResponseEntity<?> getMerchantByMid(@PathVariable String mid) {
        Merchant merchant = merchantRepository.findByMid(mid);
        if (merchant != null) {
            return ResponseEntity.ok(merchant);
        } else {
            return ResponseEntity.status(404).body("Merchant not found");
        }
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Merchant>> getPendingMerchants() {
        return ResponseEntity.ok(merchantRepository.findByIsApprovedFalse());
    }

    @GetMapping("/approved")
    public ResponseEntity<List<Merchant>> getApprovedMerchants() {
        List<Merchant> all = merchantRepository.findByIsApprovedTrueAndIsRejectedFalse();

        // ✅ Filter only for essential fields (drop dba from requirement)
        List<Merchant> filtered = all.stream()
                .filter(m -> m.getName() != null && m.getEmail() != null &&
                             m.getPassword() != null)
                .collect(Collectors.toList());

        return ResponseEntity.ok(filtered);
    }

    private String generateMid() {
        return "9202" + UUID.randomUUID().toString().substring(0, 10).replace("-", "");
    }

    private String generatePassword() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
