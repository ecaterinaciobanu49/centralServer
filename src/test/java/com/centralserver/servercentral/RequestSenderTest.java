package com.centralserver.servercentral;

import com.centralserver.servercentral.models.Customer;
import com.centralserver.servercentral.restservices.RequestSender;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.io.IOException;

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
}
