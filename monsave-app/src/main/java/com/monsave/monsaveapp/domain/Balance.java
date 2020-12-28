package com.monsave.monsaveapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity(name = "BALANCES")
public class Balance {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany(
            targetEntity = Record.class,
            mappedBy = "balance",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<Record> records;
    @OneToOne
    private Account account;
    @Column(name = "STARTING_BALANCE")
    private BigDecimal startingBalance;
    @Column(name = "BALANCE")
    private BigDecimal balanceAmount;
}
