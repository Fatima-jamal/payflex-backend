package com.payflex.controller;

import com.payflex.model.Merchant;
import com.payflex.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5174")  // Allow frontend to call this
public class MerchantController {

    @Autowired
    private MerchantRepository merchantRepository;

    @GetMapping("/merchants/{mid}")
    public ResponseEntity<?> getMerchantByMid(@PathVariable String mid) {
        Merchant merchant = merchantRepository.findByMid(mid);
        if (merchant != null) {
            return ResponseEntity.ok(merchant);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Merchant not found");
        }
    }
}
