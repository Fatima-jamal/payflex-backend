package com.payflex.service;

import com.payflex.model.RefundRequest;
import com.payflex.repository.RefundRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefundRequestService {

    @Autowired
    private RefundRequestRepository refundRequestRepository;

    public RefundRequest saveRefundRequest(RefundRequest refundRequest) {
        return refundRequestRepository.save(refundRequest);
    }

    public List<RefundRequest> getRefundsByMerchant(String merchantId) {
        return refundRequestRepository.findByMerchantId(merchantId);
    }
}
