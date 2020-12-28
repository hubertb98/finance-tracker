package com.monsave.monsaveapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "ACCOUNTS")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME")
    private String name;
    @OneToOne
    private Balance balance;

    public Account(String name) {
        this.name = name;
    }
}
