package com.payflex.repository;

import com.payflex.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByMerchantId(String merchantId);

    long countByMerchantId(String merchantId);

    long countByMerchantIdAndStatus(String merchantId, String status);

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.merchantId = :merchantId")
    Double sumAmountByMerchantId(String merchantId);

    @Query("SELECT SUM(t.paidAmount) FROM Transaction t WHERE t.merchantId = :merchantId")
    Double sumPaidAmountByMerchantId(String merchantId);
}
