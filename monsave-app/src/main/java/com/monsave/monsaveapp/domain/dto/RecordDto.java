package com.monsave.monsaveapp.domain.dto;

import com.monsave.monsaveapp.domain.AmountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RecordDto {
    private Long id;
    private String recordName;
    private double amount;
    private AmountType type;
    private LocalDate date;
}
