package com.monsave.monsaveapp.service;

import com.monsave.monsaveapp.controller.exception.NotFoundException;
import com.monsave.monsaveapp.domain.Account;
import com.monsave.monsaveapp.domain.AmountType;
import com.monsave.monsaveapp.domain.Balance;
import com.monsave.monsaveapp.domain.Record;
import com.monsave.monsaveapp.domain.dto.AccountDto;
import com.monsave.monsaveapp.domain.dto.BalanceDto;
import com.monsave.monsaveapp.domain.dto.RecordDto;
import com.monsave.monsaveapp.mapper.AccountMapper;
import com.monsave.monsaveapp.mapper.BalanceMapper;
import com.monsave.monsaveapp.mapper.RecordMapper;
import com.monsave.monsaveapp.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

@Service
public class BalanceService {
    @Autowired
    private BalanceMapper balanceMapper;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private BalanceRepository repository;

    public List<BalanceDto> getAllBalances() {
        List<BalanceDto> balanceDtoList =
                balanceMapper.toBalanceDtoList(repository.findAll());
        return balanceDtoList;
    }

    public void addBalance(final BalanceDto balanceDto) {
        List<Record> records = recordMapper.toRecordList(balanceDto.getRecords());
        Account account = accountMapper.toAccount(balanceDto.getAccount());
        Balance balance = balanceMapper.toBalance(balanceDto);
        balance.setAccount(account);
        balance.setRecords(records);
        repository.save(balance);
    }

    public Optional<BalanceDto> calculateBalance(final Long id) throws NotFoundException {
        return Optional.of(balanceMapper.toBalanceDto(repository.findById(id)
                .orElseThrow(NotFoundException::new)));
    }

    public void removeBalance(final Long id) {
        repository.deleteById(id);
    }

    public BigDecimal calculateBalance(List<Record> recordsList, BigDecimal startingBalance) {
        BigDecimal posAmount = new BigDecimal("0");
        BigDecimal negAmount = new BigDecimal("0");

        for (int i = 0; i < recordsList.size(); i++) {
            if (recordsList.get(i).getType() == AmountType.LOSS) {
                negAmount = negAmount.add(recordsList.get(i).getAmount());
            } else if (recordsList.get(i).getType() == AmountType.PROFIT) {
                posAmount = posAmount.add(recordsList.get(i).getAmount());
            }
        }
        BigDecimal balanceAmount = startingBalance.add(posAmount).subtract(negAmount);

        return balanceAmount;
    }

    public String formatBalance(BigDecimal balance) {
        return new DecimalFormat("PLN #.##").format(balance);
    }

    public List<Record> balanceDtoToRecordList(final BalanceDto balanceDto) {
        List<Record> records = recordMapper.toRecordList(balanceDto.getRecords());
        Balance balance = balanceMapper.toBalance(balanceDto);
        balance.setRecords(records);
        return records;
    }

    public List<RecordDto> balanceToRecordDtoList(final Balance balance) {
        List<RecordDto> recordsDto = recordMapper.toRecordDtoList(balance.getRecords());
        BalanceDto balanceDto = balanceMapper.toBalanceDto(balance);
        balanceDto.setRecords(recordsDto);
        return recordsDto;
    }

    public Account balanceDtoToAccount(final BalanceDto balanceDto) {
        Account account = accountMapper.toAccount(balanceDto.getAccount());
        Balance balance = balanceMapper.toBalance(balanceDto);
        account.setBalance(balance);
        return account;
    }

    public AccountDto balanceToAccountDto(final Balance balance) {
        AccountDto accountDto = accountMapper.toAccountDto(balance.getAccount());
        BalanceDto balanceDto = balanceMapper.toBalanceDto(balance);
        accountDto.setBalance(balanceDto);
        return accountDto;
    }
}
