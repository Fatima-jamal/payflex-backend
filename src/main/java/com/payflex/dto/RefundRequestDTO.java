package com.payflex.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefundRequestDTO {
    private String merchantId;
    private String transactionId;
    private int amount;
    private String reason;
}
