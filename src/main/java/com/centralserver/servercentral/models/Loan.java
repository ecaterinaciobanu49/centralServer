package com.centralserver.servercentral.models;

import java.util.Date;

public class Loan {
    private Long loanId;
    private Date startDate;
    private Date expireDate;
    private double outstandingAmount;
    private int percent;
    private LoanStatus status;
    private Customer customer;
}
