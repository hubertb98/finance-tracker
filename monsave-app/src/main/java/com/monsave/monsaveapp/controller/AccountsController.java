package com.monsave.monsaveapp.controller;

import com.monsave.monsaveapp.controller.exception.NotFoundException;
import com.monsave.monsaveapp.domain.dto.AccountDto;
import com.monsave.monsaveapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1")
public class AccountsController {
    @Autowired
    private AccountService service;

    @GetMapping(value = "/accounts")
    public List<AccountDto> getAccounts() {
        return service.getAllAccounts();
    }

    @GetMapping(value = "/accounts/{accountId}")
    public Optional<AccountDto> getAccount(@PathVariable("accountId") long accountId) throws NotFoundException {
        return service.getAccount(accountId);
    }

    @PostMapping(value = "/accounts", consumes = APPLICATION_JSON_VALUE)
    public void createAccount(@RequestBody AccountDto accountDto) {
        service.createAccount(accountDto);
    }

    @PutMapping(value = "/accounts")
    public void updateAccount(@RequestBody AccountDto accountDto) {
        service.createAccount(accountDto);
    }

    @DeleteMapping(value = "/accounts/{accountId}")
    public void removeAccount(@PathVariable("accountId") long accountId) {
        service.removeAccount(accountId);
    }
}
