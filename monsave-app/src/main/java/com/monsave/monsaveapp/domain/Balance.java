package com.monsave.monsaveapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
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
    @Column(name = "BALANCE")
    private double balance;

    public String getBalance(List<Record> recordsList) {
        DecimalFormat df = new DecimalFormat("PLN #.##");
        double posAmount = 0;
        double negAmount = 0;

        for (int i = 0; i < recordsList.size(); i++) {
            if (recordsList.get(i).getType() == AmountType.LOSS) {
                negAmount = negAmount + recordsList.get(i).getAmount();
            } else if (recordsList.get(i).getType() == AmountType.PROFIT) {
                posAmount = posAmount + recordsList.get(i).getAmount();
            }
        }
        balance = posAmount - negAmount;
        return df.format(balance);
    }
}
