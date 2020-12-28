package com.monsave.monsaveapp.repository;

import com.monsave.monsaveapp.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
