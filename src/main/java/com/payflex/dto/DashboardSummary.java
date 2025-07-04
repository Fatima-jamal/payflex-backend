package com.payflex.dto;

import lombok.Data;

@Data
public class DashboardSummary {
    private long transactionCount;
    private double totalVolume;
    private double totalPaid;
    private long successfulTransactions;
}
