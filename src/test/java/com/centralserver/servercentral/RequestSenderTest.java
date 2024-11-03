package com.centralserver.servercentral;

import com.centralserver.servercentral.models.Account;
import com.centralserver.servercentral.models.AccountType;
import com.centralserver.servercentral.models.Customer;
import com.centralserver.servercentral.models.Status;
import com.centralserver.servercentral.restservices.RequestSender;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
public class RequestSenderTest {

    private static final String TEST_USER = "{\n" +
            "  \"subjectCode\": \"CUST99887\",\n" +
            "  \"lastname\": \"Williams\",\n" +
            "  \"firstname\": \"Michael\",\n" +
            "  \"email\": \"michaelwilliams@example.com\",\n" +
            "  \"phone\": \"+12012345678\",\n" +
            "  \"birthDate\": \"1988-11-25T08:20:00.000Z\"\n" +
            "}\n";

    private static final String CUSTOMER_CODE = "CUST99887";
    private static final String NEW_EMAIL = "michaelwilliams1@example.com";
    private static final String ACCOUNT_NUMBER = "ACCOUNT12";
    private static final String PORT = "8080";
    @Test
    public void testAddNewCustomer() throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = RequestSender.createNewCustomer(objectMapper.readValue(TEST_USER, Customer.class), "8080");

        Assertions.assertEquals("Michael", customer.getFirstname());
    }

    @Test
    public void testGetCustomerBySubjectCode() throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = RequestSender.getCustomerBySubjectCode(CUSTOMER_CODE, "8080");

        Assertions.assertEquals("Michael", customer.getFirstname());
    }

    @Test
    public void testEditCustomerEmail() throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = RequestSender.editCustomerEmail(CUSTOMER_CODE, NEW_EMAIL,"8080");

        Assertions.assertEquals(NEW_EMAIL, customer.getEmail());
    }

    @Test
    public void testAddAccount() throws IOException, InterruptedException {
        Account account = new Account(ACCOUNT_NUMBER, AccountType.CHECKING, 0d,
                Status.ACTIVE, RequestSender.getCustomerBySubjectCode(CUSTOMER_CODE, "8080"));

        Account savedAccount = RequestSender.addNewAccount(account, "8080");

        Assertions.assertEquals(savedAccount.getAccountNumber(), ACCOUNT_NUMBER);
    }

    @Test
    public void testGetAllAccountsBySubjectCode () throws IOException, InterruptedException {
        List<Account> accounts = RequestSender.getAllAccountsBySubjectCode(CUSTOMER_CODE, PORT);

        Assertions.assertEquals(4, accounts.size());
    }

    @Test
    public void testGetAccountByAccountNumber () throws IOException, InterruptedException {
        Account account = RequestSender.getAccountByAccountNumber(ACCOUNT_NUMBER, PORT);

        Assertions.assertEquals(0d, account.getBalance());
    }

    @Test
    public void testUpdateAccountBalance() throws IOException, InterruptedException {
        Account savedAccount = RequestSender.updateAccountBalance(ACCOUNT_NUMBER, 1500d, PORT);

        Assertions.assertEquals(1500d, savedAccount.getBalance());
    }

    @Test
    public void testCloseAccount() throws IOException, InterruptedException {
        RequestSender.closeAccount(ACCOUNT_NUMBER, PORT);

        Account savedAccount = RequestSender.getAccountByAccountNumber(ACCOUNT_NUMBER, PORT);

        Assertions.assertEquals(savedAccount.getStatus(), Status.CLOSED);
    }
}
