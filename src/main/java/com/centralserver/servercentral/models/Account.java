package com.centralserver.servercentral.models;

import lombok.Data;

@Data
public class Account {
    private Long accountId;
    private String accountNumber;
    private AccountType accountType;
    private double balance;
    private Status status;
    private Customer customer;
}
