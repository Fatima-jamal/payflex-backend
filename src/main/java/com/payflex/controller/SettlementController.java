package com.payflex.controller;

import com.payflex.model.Settlement;
import com.payflex.repository.SettlementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/settlements")
@CrossOrigin(origins = "*")
public class SettlementController {

    @Autowired
    private SettlementRepository settlementRepository;

    @GetMapping("/{mid}")
    public List<Settlement> getSettlementsByMid(@PathVariable String mid) {
        return settlementRepository.findByMid(mid);
    }
}
