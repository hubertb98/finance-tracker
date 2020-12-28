package com.monsave.monsaveapp.controller;

import com.monsave.monsaveapp.controller.exception.NotFoundException;
import com.monsave.monsaveapp.domain.dto.BalanceDto;
import com.monsave.monsaveapp.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1")
public class BalancesController {
    @Autowired
    private BalanceService service;

    @GetMapping(value = "/balances")
    public List<BalanceDto> getBalances() {
        return service.getAllBalances();
    }

    @GetMapping(value = "/balances/{balanceId}")
    public Optional<BalanceDto> getBalance(@PathVariable("balanceId") long balanceId) throws NotFoundException {
        return service.calculateBalance(balanceId);
    }

    @PostMapping(value = "/balances", consumes = APPLICATION_JSON_VALUE)
    public void createBalance(@RequestBody BalanceDto balanceDto) {
        service.addBalance(balanceDto);
    }

    @PutMapping(value = "/balances")
    public void updateBalance(@RequestBody BalanceDto balanceDto) {
        service.addBalance(balanceDto);
    }

    @DeleteMapping(value = "/balances/{balanceId}")
    public void removeBalance(@PathVariable("balanceId") long balanceId) {
        service.removeBalance(balanceId);
    }

}
