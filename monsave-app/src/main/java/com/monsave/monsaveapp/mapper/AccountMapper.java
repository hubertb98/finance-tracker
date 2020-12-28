package com.monsave.monsaveapp.mapper;

import com.monsave.monsaveapp.domain.Account;
import com.monsave.monsaveapp.domain.dto.AccountDto;
import com.monsave.monsaveapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {
    @Autowired
    private AccountService service;
    public Account toAccount(final AccountDto accountDto) {
        return new Account(
                accountDto.getId(),
                accountDto.getName(),
                service.toBalance(accountDto));
    }

    public AccountDto toAccountDto(final Account account) {
        return new AccountDto(
                account.getId(),
                account.getName(),
                service.toBalanceDto(account));
    }

    public List<Account> toAccountList(final List<AccountDto> accountDtoList) {
        return accountDtoList.stream()
                .map(this::toAccount)
                .collect(Collectors.toList());
    }

    public List<AccountDto> toAccountDtoList(final List<Account> accountList) {
        return accountList.stream()
                .map(this::toAccountDto)
                .collect(Collectors.toList());
    }
}
