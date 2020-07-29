package com.gccm.creditcard.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gccm.creditcard.model.ValidationRequest;
import com.gccm.creditcard.model.ValidationResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreditCardControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void restResponseShouldMatchTestCaseOutput() throws Exception {

        // Load tests from JSON file
        ObjectMapper objectMapper = new ObjectMapper();
        CardTest[] cardTests = objectMapper
                .readValue(new File("src/test/resources/creditcards.json"), CardTest[].class);

        // Run tests
        for (CardTest cardTest: cardTests) {

            HttpEntity<ValidationRequest> request =
                    new HttpEntity<>(new ValidationRequest(cardTest.getInput()));

            ValidationResult result =
                    this.restTemplate.postForObject("http://localhost:" + port + "/api/validate",
                            request, ValidationResult.class);

            String actual =
                    String.format("%s: %s (%s)", result.getVendor(), result.getCardNumber(), result.getStatus());

            assertEquals(cardTest.getOutput(), actual);
        }
    }
}
