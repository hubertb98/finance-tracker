package com.monsave.monsaveapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private long id;
    private String name;
    private BalanceDto balance;
}
