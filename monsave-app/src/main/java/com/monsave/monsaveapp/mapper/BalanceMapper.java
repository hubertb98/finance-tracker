package com.monsave.monsaveapp.mapper;

import com.monsave.monsaveapp.domain.Balance;
import com.monsave.monsaveapp.domain.dto.BalanceDto;
import com.monsave.monsaveapp.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BalanceMapper {
    @Autowired
    private BalanceService service;

    public Balance toBalance(final BalanceDto balanceDto) {
        return new Balance(
                balanceDto.getId(),
                service.balanceDtoToRecordList(balanceDto),
                service.balanceDtoToAccount(balanceDto),
                balanceDto.getStartingBalance(),
                balanceDto.getBalanceAmount());
    }

    public BalanceDto toBalanceDto(final Balance balance) {
        return new BalanceDto(
                balance.getId(),
                service.balanceToRecordDtoList(balance),
                service.balanceToAccountDto(balance),
                balance.getStartingBalance(),
                balance.getBalanceAmount());
    }

    public List<Balance> toBalanceList(final List<BalanceDto> balanceDtoList) {
        return balanceDtoList.stream()
                .map(this::toBalance)
                .collect(Collectors.toList());
    }

    public List<BalanceDto> toBalanceDtoList(final List<Balance> balanceList) {
        return balanceList.stream()
                .map(this::toBalanceDto)
                .collect(Collectors.toList());
    }
}
