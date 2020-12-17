package com.monsave.monsaveapp.mapper;

import com.monsave.monsaveapp.domain.Account;
import com.monsave.monsaveapp.domain.dto.AccountDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {
    private BalanceMapper balanceMapper;
    public Account toAccount(final AccountDto accountDto) {
        return new Account(
                accountDto.getId(),
                accountDto.getName(),
                balanceMapper.toBalance(accountDto.getBalance()));
    }

    public AccountDto toAccountDto(final Account account) {
        return new AccountDto(
                account.getId(),
                account.getName(),
                balanceMapper.toBalanceDto(account.getBalance()));
    }

    public List<Account> toAccountList(final List<AccountDto> accountDtoList) {
        return accountDtoList.stream()
                .map(accountDto -> new Account(accountDto.getId(), accountDto.getName(), balanceMapper.toBalance(accountDto.getBalance())))
                .collect(Collectors.toList());
    }

    public List<AccountDto> toAccountDtoList(final List<Account> accountList) {
        return accountList.stream()
                .map(account -> new AccountDto(account.getId(), account.getName(), balanceMapper.toBalanceDto(account.getBalance())))
                .collect(Collectors.toList());
    }
}
