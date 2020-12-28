package com.monsave.monsaveapp.domain.dto;

import com.monsave.monsaveapp.domain.AmountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecordDto {
    private Long id;
    private String recordName;
    private BigDecimal amount;
    private AmountType type;
    private LocalDate date;
}
