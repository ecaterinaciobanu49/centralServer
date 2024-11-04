package com.centralserver.servercentral.restservices;

import com.centralserver.servercentral.models.Account;
import com.centralserver.servercentral.models.Customer;
import com.centralserver.servercentral.models.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static com.centralserver.servercentral.constants.HttpConstants.*;

public class RequestSender {
    public static ObjectMapper objectMapper = new ObjectMapper();

    public static Customer createNewCustomer(Customer customer, String port) throws IOException, InterruptedException {
        String requestBody = objectMapper.writeValueAsString(customer);

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .uri(URI.create(LOCALHOST + port + POST_CUSTOMER))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());

        return objectMapper.readValue(response.body(), Customer.class);
    }

    public static Customer getCustomerBySubjectCode(String subjectCode, String port) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(LOCALHOST + port + GET_CUSTOMER_BY_CUSTOMER_CODE + subjectCode))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), Customer.class);
    }

    public static Customer editCustomerEmail(String subjectCode, String newEmail, String port) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(newEmail))
                .uri(URI.create(LOCALHOST + port + PUT_CUSTOMER_EMAIL + subjectCode))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), Customer.class);
    }

    public void deleteCustomer(String subjectCode, String port) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create(LOCALHOST + port + DELETE_CUSTOMER + subjectCode))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
    }

    public static Account addNewAccount(Account account, String port) throws IOException, InterruptedException {
        String requestBody = objectMapper.writeValueAsString(account);

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .uri(URI.create(LOCALHOST + port + POST_ACCOUNT))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return objectMapper.readValue(response.body(), Account.class);
    }

    public static List<Account> getAllAccountsBySubjectCode(String subjectCode, String port) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(LOCALHOST + port + GET_ACCOUNTS_BY_CUSTOMER_CODE + subjectCode))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return objectMapper.readValue(response.body(), new TypeReference<List<Account>>() {});
    }

    public static Account getAccountByAccountNumber(String accountNumber, String port) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(LOCALHOST + port + GET_ACCOUNT_BY_NUMBER + accountNumber))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return objectMapper.readValue(response.body(), Account.class);
    }

    public static Account updateAccountBalance(String accountNumber, Double balance, String port) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(String.valueOf(balance)))
                .uri(URI.create(LOCALHOST + port + PUT_ACCOUNT_BALANCE + accountNumber))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return objectMapper.readValue(response.body(), Account.class);
    }

    public static void closeAccount(String accountNumber, String port) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.noBody())
                .uri(URI.create(LOCALHOST + port + PUT_CLOSE_ACCOUNT + accountNumber))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
    }

    public static Transaction addNewTransaction(Transaction transaction, String port) throws IOException, InterruptedException {

        String requestBody = objectMapper.writeValueAsString(transaction);

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .uri(URI.create(LOCALHOST + port + POST_TRANSACTION))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return objectMapper.readValue(response.body(), Transaction.class);
    }

    public static List<Transaction> getAllTransactionByAccountId(Long accountId, String port) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(LOCALHOST + port + GET_TRANSACTION_BY_ACCOUNT + accountId))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return objectMapper.readValue(response.body(), new TypeReference<List<Transaction>>() {});
    }

    public static Transaction getTransactionById(Long transactionId, String port) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(LOCALHOST + port + GET_TRANSACTION_BY_ID + transactionId))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return objectMapper.readValue(response.body(), Transaction.class);
    }
}
