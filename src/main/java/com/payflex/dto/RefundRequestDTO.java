package com.payflex.dto;

import lombok.Data;

@Data
public class RefundRequestDTO {
    private String merchantId;
    private String transactionId;
    private String reason;
    private double amount;
}
