package com.payflex.controller;

import com.payflex.model.Merchant;
import com.payflex.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private MerchantRepository merchantRepository;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> payload) {
        String mid = payload.get("mid");
        String password = payload.get("password");

        Merchant merchant = merchantRepository.findByMid(mid);
        Map<String, Object> response = new HashMap<>();

        if (merchant != null && merchant.getPassword().equals(password)) {
            response.put("status", "success");
            response.put("mid", merchant.getMid());
            response.put("isApproved", merchant.isApproved());  // Corrected here
        } else {
            response.put("status", "failure");
        }

        return response;
    }
}
