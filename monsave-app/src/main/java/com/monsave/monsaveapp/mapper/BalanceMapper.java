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
                recordMapper.toRecordList(balanceDto.getRecords()),
                accountMapper.toAccount(balanceDto.getAccount()),
                balanceDto.getStartingBalance(),
                balanceDto.getBalance());
    }

    public BalanceDto toBalanceDto(final Balance balance) {
        return new BalanceDto(
                balance.getId(),
                recordMapper.toRecordDtoList(balance.getRecords()),
                accountMapper.toAccountDto(balance.getAccount()),
                balance.getStartingBalance(),
                balance.getBalance());
    }

    public List<Balance> toBalanceList(final List<BalanceDto> balanceDtoList) {
        return balanceDtoList.stream()
                .map(bDL -> new Balance(
                        bDL.getId(),
                        recordMapper.toRecordList(bDL.getRecords()),
                        accountMapper.toAccount(bDL.getAccount()),
                        bDL.getStartingBalance(),
                        bDL.getBalance()))
                .collect(Collectors.toList());
    }

    public List<BalanceDto> toBalanceDtoList(final List<Balance> balanceList) {
        return balanceList.stream()
                .map(bL -> new BalanceDto(
                        bL.getId(),
                        recordMapper.toRecordDtoList(bL.getRecords()),
                        accountMapper.toAccountDto(bL.getAccount()),
                        bL.getStartingBalance(),
                        bL.getBalance()))
                .collect(Collectors.toList());
    }


}
