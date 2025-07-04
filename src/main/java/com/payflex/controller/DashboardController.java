package com.payflex.controller;

import com.payflex.dto.DashboardSummary;
import com.payflex.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin
@RequiredArgsConstructor
public class DashboardController {

    private final TransactionRepository transactionRepository;

    @GetMapping("/summary")
    public DashboardSummary getDashboardSummary(@RequestParam String merchantId) {
        DashboardSummary summary = new DashboardSummary();

        summary.setTransactionCount(transactionRepository.countByMerchantId(merchantId));
        summary.setTotalVolume(transactionRepository.sumAmountByMerchantId(merchantId));
        summary.setTotalPaid(transactionRepository.sumPaidAmountByMerchantId(merchantId));
        summary.setSuccessfulTransactions(transactionRepository.countByMerchantIdAndStatus(merchantId, "SUCCESS"));

        return summary;
    }
}
