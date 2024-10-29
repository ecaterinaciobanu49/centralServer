package com.centralserver.servercentral.models;

import lombok.Data;

import java.util.Date;

@Data
public class Customer {
    private Long customerId;
    private String subjectCode;
    private String name;
    private String surName;
    private String email;
    private String phone;
    private Date birthDate;
}
