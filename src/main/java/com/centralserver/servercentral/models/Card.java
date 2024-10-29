package com.centralserver.servercentral.models;

import lombok.Data;

import java.util.Date;

@Data
public class Card {
    private Long cardId;
    private String cardNumber;
    private Date expireDate;
    private String cvv;
    private Customer customer;
}
