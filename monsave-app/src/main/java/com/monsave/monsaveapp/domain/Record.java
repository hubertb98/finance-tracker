package com.monsave.monsaveapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private double amount;

    @Column(name = "TYPE")
    private AmountType type;

    @Column(name = "DATE")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "BALANCE_ID")
    private Balance balance;

    public String printAmount() {
        String printAmount = "";
        if (type == AmountType.LOSS) {
            printAmount = "-PLN " + amount;
        } else if (type == AmountType.PROFIT) {
            printAmount = "PLN " + amount;
        }
        return printAmount;
    }

    public Record(Long id, String recordName, double amount, AmountType type, LocalDate date) {
        this.id = id;
        this.recordName = recordName;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }
}
