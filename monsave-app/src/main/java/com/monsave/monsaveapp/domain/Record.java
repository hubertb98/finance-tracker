package com.monsave.monsaveapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "RECORDS")
public class Record {
    @Id
    @Column(name = "RECORD_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "RECORD_NAME")
    private String recordName;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "TYPE")
    private AmountType type;

    @Column(name = "DATE")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "BALANCE_ID")
    private Balance balance;

    public Record(Long id, String recordName, BigDecimal amount, AmountType type, LocalDate date) {
        this.id = id;
        this.recordName = recordName;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }
}
