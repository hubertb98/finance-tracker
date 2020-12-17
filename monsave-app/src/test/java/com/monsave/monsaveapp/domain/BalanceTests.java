package com.monsave.monsaveapp.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BalanceTests {

    @Test
    public void getBalance() {
        //Given
        List<Record> records = new ArrayList<>();
        Record fuel = new Record(1L, "fuel", 50, AmountType.PROFIT, LocalDate.now());
        Record gas = new Record(1L, "gas", 100.01, AmountType.PROFIT, LocalDate.now());
        Record gas1 = new Record(1L, "gas", 100.01, AmountType.PROFIT, LocalDate.now());

        records.add(fuel);
        records.add(gas);
        records.add(gas1);

        Balance julyBalance = new Balance();
        //when
        String balance = julyBalance.getBalance(records);

        //Then
        System.out.println(balance);

    }
}