package com.centralserver.servercentral.restservices;

import com.centralserver.servercentral.models.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.centralserver.servercentral.constants.HttpConstants.LOCALHOST;
import static com.centralserver.servercentral.constants.HttpConstants.POST_CUSTOMER;

public class RequestSender {

    public static Customer createNewCustomer(Customer customer, String port) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
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


}
