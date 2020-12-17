package com.monsave.monsaveapp.mapper;

import com.monsave.monsaveapp.domain.Balance;
import com.monsave.monsaveapp.domain.dto.BalanceDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BalanceMapper {
    private RecordMapper recordMapper;
    private AccountMapper accountMapper;
    public Balance toBalance(final BalanceDto balanceDto) {
        return new Balance(
                balanceDto.getId(),
                recordMapper.mapToRecordList(balanceDto.getRecords()),
                accountMapper.toAccount(balanceDto.getAccount()),
                balanceDto.getBalance());
    }

    public BalanceDto toBalanceDto(final Balance balance) {
        return new BalanceDto(
                balance.getId(),
                recordMapper.maoToRecordDtoList(balance.getRecords()),
                accountMapper.toAccountDto(balance.getAccount()),
                balance.getBalance());
    }

    public List<Balance> toBalanceList(final List<BalanceDto> balanceDtoList) {
        return balanceDtoList.stream()
                .map(bDL -> new Balance(
                        bDL.getId(),
                        recordMapper.mapToRecordList(bDL.getRecords()),
                        accountMapper.toAccount(bDL.getAccount()),
                        bDL.getBalance()))
                .collect(Collectors.toList());
    }

    public List<BalanceDto> toBalanceDtoList(final List<Balance> balanceList) {
        return balanceList.stream()
                .map(bL -> new BalanceDto(
                        bL.getId(),
                        recordMapper.maoToRecordDtoList(bL.getRecords()),
                        accountMapper.toAccountDto(bL.getAccount()),
                        bL.getBalance()))
                .collect(Collectors.toList());
    }


}
