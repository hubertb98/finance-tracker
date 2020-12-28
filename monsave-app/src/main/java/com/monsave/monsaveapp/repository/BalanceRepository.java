package com.monsave.monsaveapp.repository;

import com.monsave.monsaveapp.domain.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {
}
