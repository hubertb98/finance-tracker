package com.monsave.monsaveapp.domain;

import com.monsave.monsaveapp.mapper.BalanceMapper;
import com.monsave.monsaveapp.service.BalanceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BalanceTests {
    @Autowired
    private BalanceMapper mapper;
    @Autowired
    private BalanceService service;

    @Test
    public void shouldCalculateBalanceAmount() {
        //Given
        List<Record> records = new ArrayList<>();
        Record fuel = new Record(1L, "fuel", new BigDecimal("50"), AmountType.PROFIT, LocalDate.now());
        Record gas = new Record(2L, "gas", new BigDecimal("100.01"), AmountType.LOSS, LocalDate.now());
        Record gas1 = new Record(3L, "gas1", new BigDecimal("100.01"), AmountType.LOSS, LocalDate.now());

        records.add(fuel);
        records.add(gas);
        records.add(gas1);

        Balance julyBalance = new Balance();
        julyBalance.setStartingBalance(new BigDecimal("215.5"));
        //when
        BigDecimal balanceAmount = service.calculateBalance(records,julyBalance.getStartingBalance());

        //Then
        System.out.println(balanceAmount);

    }

    @Test
    public void shouldGetBalances() {
        //Given
        List<Record> recordList = new ArrayList<>();

        Balance test = new Balance();
        Account account = new Account(2L,"Bank", test);

        long id = 1L;
        BigDecimal startingBalance = new BigDecimal("100");

        test.setId(id);
        test.setAccount(account);
        test.setRecords(recordList);
        test.setStartingBalance(startingBalance);
        BigDecimal balance = service.calculateBalance(recordList, test.getStartingBalance());
        test.setBalanceAmount(balance);

        try {
            mapper.toBalanceDto(test);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}