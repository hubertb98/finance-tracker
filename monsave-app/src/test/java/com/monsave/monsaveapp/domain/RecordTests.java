package com.monsave.monsaveapp.domain;

import com.monsave.monsaveapp.domain.dto.RecordDto;
import com.monsave.monsaveapp.mapper.RecordMapper;
import com.monsave.monsaveapp.service.RecordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
class RecordTests {
    @Autowired
    private RecordMapper mapper;
    @Autowired
    private RecordService service;

    @Test
    public void printAmountTest() {
        //Given
        Record fuel = new Record(1L, "Fuel", new BigDecimal("100.0"), AmountType.PROFIT, LocalDate.now());
        Record shopping = new Record(2L, "Fuel", new BigDecimal("100.0"), AmountType.LOSS, LocalDate.now());

        //When
        String amount = service.printAmount(fuel);
        String shoppingAmount = service.printAmount(shopping);

        //Then
        System.out.println(amount);
        System.out.println(shoppingAmount);
    }

    @Test
    public void getRecords() {
        //Given
        Record fuel = new Record(1L, "Fuel", new BigDecimal("100.0"), AmountType.PROFIT, LocalDate.now());


        //When
        RecordDto fuelDto = mapper.toRecordDto(fuel);
        service.createRecord(fuelDto);

        //Then
        try {
            System.out.println(service.getRecord(1L));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}