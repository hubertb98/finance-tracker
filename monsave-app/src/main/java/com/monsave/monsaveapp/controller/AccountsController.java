package com.monsave.monsaveapp.controller;

import com.monsave.monsaveapp.controller.exception.AccountNotFoundException;
import com.monsave.monsaveapp.domain.dto.AccountDto;
import com.monsave.monsaveapp.mapper.AccountMapper;
import com.monsave.monsaveapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1")
public class AccountsController {
    @Autowired
    private AccountMapper mapper;
    @Autowired
    private AccountService service;

    @GetMapping(value = "/accounts")
    public List<AccountDto> getAccounts() {
        return mapper.toAccountDtoList(service.getAllAccounts());
    }

    @GetMapping(value = "/accounts/{accountId}")
    public AccountDto getAccount(@PathVariable("accountId") long accountId) throws AccountNotFoundException {
        return mapper.toAccountDto(service.getAccount(accountId).orElseThrow(AccountNotFoundException::new));
    }

    @PostMapping(value = "/accounts", consumes = APPLICATION_JSON_VALUE)
    public void createAccount(@RequestBody AccountDto accountDto) {
        service.saveAccount(mapper.toAccount(accountDto));
    }

    @PutMapping(value = "/accounts")
    public AccountDto updateAccount(@RequestBody AccountDto accountDto) {
        return mapper.toAccountDto(service.saveAccount(mapper.toAccount(accountDto)));
    }

    @DeleteMapping(value = "/accounts/{accountId}")
    public void deleteAccount(@PathVariable("accountId") long accountId) {
        service.deleteAccount(accountId);
    }
}
