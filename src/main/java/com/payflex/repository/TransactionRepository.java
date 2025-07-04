package com.payflex.repository;

import com.payflex.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByMid(String mid);

    @Query("SELECT COUNT(t) FROM Transaction t WHERE t.mid = ?1")
    long countByMid(String mid);

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.mid = ?1")
    Double sumAmountByMid(String mid);

    @Query("SELECT SUM(t.paidAmount) FROM Transaction t WHERE t.mid = ?1")
    Double sumPaidAmountByMid(String mid);

    @Query("SELECT COUNT(t) FROM Transaction t WHERE t.mid = ?1 AND t.status = ?2")
    long countByMidAndStatus(String mid, String status);
}
