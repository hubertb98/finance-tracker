package com.monsave.monsaveapp.repository;

import com.monsave.monsaveapp.domain.Balance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BalanceRepository extends CrudRepository<Balance, Long> {
    @Override
    List<Balance> findAll();

    @Override
    Balance save(Balance balance);

    @Override
    Optional<Balance> findById(Long id);

    @Override
    void deleteById(Long id);
}
