package com.monsave.monsaveapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BalanceDto {
    private long id;
    private List<RecordDto> records;
    private AccountDto account;
    private double balance;
}
