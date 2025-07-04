// src/main/java/com/payflex/controller/TransactionController.java
package com.payflex.controller;

import com.payflex.model.Transaction;
import com.payflex.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionRepository transactionRepository;

    @GetMapping("/mid/{mid}")
    public List<Transaction> getTransactionsByMid(@PathVariable String mid) {
        return transactionRepository.findByMid(mid);
    }
}
