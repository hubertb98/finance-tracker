package com.monsave.monsaveapp.service;

import com.monsave.monsaveapp.domain.Balance;
import com.monsave.monsaveapp.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalanceService {
    @Autowired
    private BalanceRepository repository;

    public List<Balance> getAllBalances() {
        return repository.findAll();
    }

    public Balance saveBalance(final Balance balance) {
        return repository.save(balance);
    }

    public Optional<Balance> getBalance(final Long id) {
        return repository.findById(id);
    }

    public void deleteBalance(final Long id) {
        repository.deleteById(id);
    }
}
