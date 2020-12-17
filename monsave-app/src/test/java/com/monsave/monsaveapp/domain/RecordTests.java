package com.monsave.monsaveapp.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class RecordTests {
    @Test
    public void printAmountTest() {
        //Given
        Record fuel = new Record(1L, "Fuel", 100.0, AmountType.PROFIT, LocalDate.now());
        Record shopping = new Record(2L, "Fuel", 100.0, AmountType.LOSS, LocalDate.now());

        //When
        String amount = fuel.printAmount();
        String shoppingAmount = shopping.printAmount();

        //Then
        System.out.println(amount);
        System.out.println(shoppingAmount);
    }

}