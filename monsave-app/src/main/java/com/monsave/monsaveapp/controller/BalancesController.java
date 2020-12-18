package com.monsave.monsaveapp.controller;

import com.monsave.monsaveapp.controller.exception.BalanceNotFoundException;
import com.monsave.monsaveapp.domain.dto.BalanceDto;
import com.monsave.monsaveapp.mapper.BalanceMapper;
import com.monsave.monsaveapp.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1")
public class BalancesController {
    @Autowired
    private BalanceMapper mapper;
    @Autowired
    private BalanceService service;

    @GetMapping(value = "/balances")
    public List<BalanceDto> getBalances() {
        return mapper.toBalanceDtoList(service.getAllBalances());
    }

    @GetMapping(value = "/balances/{balanceId}")
    public BalanceDto getBalance(@PathVariable("balanceId") long balanceId) throws BalanceNotFoundException {
        return mapper.toBalanceDto(service.getBalance(balanceId).orElseThrow(BalanceNotFoundException::new));
    }

    @PostMapping(value = "/balances", consumes = APPLICATION_JSON_VALUE)
    public void createBalance(@RequestBody BalanceDto balanceDto) {
        service.saveBalance(mapper.toBalance(balanceDto));
    }

    @PutMapping(value = "/balances")
    public BalanceDto updateBalance(@RequestBody BalanceDto balanceDto) {
        return mapper.toBalanceDto(service.saveBalance(mapper.toBalance(balanceDto)));
    }

    @DeleteMapping(value = "/balances/{balanceId}")
    public void deleteBalance(@PathVariable("balanceId") long balanceId) {
        service.deleteBalance(balanceId);
    }

}
