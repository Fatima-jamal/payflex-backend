package com.payflex.repository;

import com.payflex.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
    Merchant findByMid(String mid);
    List<Merchant> findByIsApprovedFalse();
    List<Merchant> findByIsApprovedTrue();
}
