package com.monsave.monsaveapp.dao;

import com.monsave.monsaveapp.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    @Override
    List<Account> findAll();

    @Override
    Optional<Account> findById(Long id);

    @Override
    Account save(Account account);

    @Override
    void deleteById(Long id);
}
