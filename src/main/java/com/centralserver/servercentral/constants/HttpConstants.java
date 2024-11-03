package com.centralserver.servercentral.constants;

import java.lang.module.FindException;

public class HttpConstants {
    public static final String LOCALHOST = "http://localhost:";
    public static final String POST_CUSTOMER = "/customer";
    public static final String GET_CUSTOMER_BY_CUSTOMER_CODE = "/findCustomerBySubjectCode/";
    public static final String PUT_CUSTOMER_EMAIL = "/editCustomerEmail/";
    public static final String DELETE_CUSTOMER = "/deleteCustumer/";
    public static final String POST_CARD = "/createNewCard";
    public static final String POST_ACCOUNT = "/addNewAccount";
    public static final String GET_ACCOUNTS_BY_CUSTOMER_CODE = "/getAccountsBySubjcetCode/";
    public static final String GET_ACCOUNT_BY_NUMBER = "/getAnAccountByAccountNumber/";
    public static final String PUT_ACCOUNT_BALANCE = "/updateAccountBalance/";
    public static final String PUT_CLOSE_ACCOUNT = "/closeAccount/";

}
