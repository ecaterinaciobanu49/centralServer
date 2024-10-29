package com.centralserver.servercentral.models;

import java.util.Date;

public class Transaction {
    private Long transactionId;
    private double sum;
    private Date transactionDate;
    private TransactionType transactionType;
    private Account account;
}
