package com.monsave.monsaveapp.controller;

import com.monsave.monsaveapp.domain.dto.AccountDto;
import com.monsave.monsaveapp.domain.dto.BalanceDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/")
public class AccountsController {

    @GetMapping(value = "/accounts")
    public List<AccountDto> getAccounts() {
        return new ArrayList<>();
    }

    @GetMapping(value = "/accounts/{accountId}")
    public AccountDto getAccount(@PathVariable("accountId") long accountId) {
        return new AccountDto();
    }

    @PostMapping(value = "/accounts")
    public void createAccount() {
    }

    @PutMapping(value = "/accounts", consumes = APPLICATION_JSON_VALUE)
    public AccountDto updateAccount(@RequestBody AccountDto accountDto) {
        return new AccountDto();
    }

    @DeleteMapping(value = "/accounts/{accountId}")
    public void deleteAccount(@PathVariable("accountId") long accountId) {
    }

    @GetMapping(value = "/balance")
    public BalanceDto getBalance() {
        return new BalanceDto();
    }


}
