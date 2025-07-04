package com.payflex.service;

import com.payflex.dto.RefundRequestDTO;
import com.payflex.model.RefundRequest;
import com.payflex.repository.RefundRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefundRequestService {

    private final RefundRequestRepository refundRequestRepository;

    public RefundRequest createRefundRequest(RefundRequestDTO dto) {
        RefundRequest refund = new RefundRequest();

        // Fix: Convert Strings to Integer
        refund.setMerchantId(Integer.parseInt(dto.getMerchantId()));
        refund.setTransactionId(Integer.parseInt(dto.getTransactionId()));

        refund.setReason(dto.getReason());
        refund.setAmount(dto.getAmount());
        refund.setStatus("PENDING");

        return refundRequestRepository.save(refund);
    }
}
