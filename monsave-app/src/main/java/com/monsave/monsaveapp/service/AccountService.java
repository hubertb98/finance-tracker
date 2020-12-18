package com.monsave.monsaveapp.service;

import com.monsave.monsaveapp.domain.Account;
import com.monsave.monsaveapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Account saveAccount(final Account account) {
        return repository.save(account);
    }

    public Optional<Account> getAccount(final Long id) {
        return repository.findById(id);
    }

    public void deleteAccount(final Long id) {
        repository.deleteById(id);
    }

}
