package com.payflex.controller;

import com.payflex.dto.DashboardSummary;
import com.payflex.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class DashboardController {

    private final TransactionRepository transactionRepository;

    @GetMapping("/summary")
    public DashboardSummary getDashboardSummary(@RequestParam String mid) {
        DashboardSummary summary = new DashboardSummary();

        Long count = transactionRepository.countByMid(mid);
        Double volume = transactionRepository.sumAmountByMid(mid);
        Double paid = transactionRepository.sumPaidAmountByMid(mid);
        Long successCount = transactionRepository.countByMidAndStatus(mid, "SUCCESS");

        summary.setTransactionCount(count != null ? count : 0);
        summary.setTotalVolume(volume != null ? volume : 0.0);
        summary.setTotalPaid(paid != null ? paid : 0.0);
        summary.setSuccessfulTransactions(successCount != null ? successCount : 0);

        System.out.println("Dashboard Summary: " + summary);
        return summary;
    }
}
