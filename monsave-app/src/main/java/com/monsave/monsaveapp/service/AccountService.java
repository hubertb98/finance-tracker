package com.monsave.monsaveapp.service;

import com.monsave.monsaveapp.controller.exception.NotFoundException;
import com.monsave.monsaveapp.domain.Account;
import com.monsave.monsaveapp.domain.Balance;
import com.monsave.monsaveapp.domain.dto.AccountDto;
import com.monsave.monsaveapp.domain.dto.BalanceDto;
import com.monsave.monsaveapp.mapper.AccountMapper;
import com.monsave.monsaveapp.mapper.BalanceMapper;
import com.monsave.monsaveapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private BalanceMapper balanceMapper;
    @Autowired
    private AccountMapper accountMapper;

    public List<AccountDto> getAllAccounts() {
        List<AccountDto> accountDtoList =
                accountMapper.toAccountDtoList(accountRepository.findAll());
        return accountDtoList;
    }

    public void createAccount(final AccountDto accountDto) {
        Balance balance = balanceMapper.toBalance(accountDto.getBalance());
        Account account = accountMapper.toAccount(accountDto);
        account.setBalance(balance);
        accountRepository.save(account);
    }

    public Optional<AccountDto> getAccount(final Long id) throws NotFoundException {
        return Optional.of(accountMapper.toAccountDto(accountRepository.findById(id)
                .orElseThrow(NotFoundException::new)));
    }

    public void removeAccount(final Long id) {
        accountRepository.deleteById(id);
    }

    public Balance toBalance(final AccountDto accountDto) {
        Balance balance = balanceMapper.toBalance(accountDto.getBalance());
        Account account = accountMapper.toAccount(accountDto);
        balance.setAccount(account);
        return balance;
    }

    public BalanceDto toBalanceDto(final Account account) {
        BalanceDto balanceDto = balanceMapper.toBalanceDto(account.getBalance());
        AccountDto accountDto = accountMapper.toAccountDto(account);
        balanceDto.setAccount(accountDto);
        return balanceDto;
    }
}
