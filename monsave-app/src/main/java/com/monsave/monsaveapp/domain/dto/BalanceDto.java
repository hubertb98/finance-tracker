package com.monsave.monsaveapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BalanceDto {
    private long id;
    private List<RecordDto> records;
    private AccountDto account;
    private BigDecimal startingBalance;
    private BigDecimal balanceAmount;
}
