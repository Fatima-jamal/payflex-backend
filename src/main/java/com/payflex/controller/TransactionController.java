package com.payflex.controller;

import com.payflex.model.Transaction;
import com.payflex.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "*")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/{mid}")
    public List<Transaction> getTransactionsByMid(@PathVariable String mid) {
        return transactionRepository.findByMerchantId(mid);  // ✅ Corrected method name
    }
}
