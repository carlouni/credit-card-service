package com.gccm.creditcard.strategy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VisaStrategyTest {

    private final VisaStrategy visaStrategy;
    private final Map<String, Boolean> testCases;

    @Autowired
    public VisaStrategyTest(VisaStrategy visaStrategy) {
        this.visaStrategy = visaStrategy;
        this.testCases = new HashMap<>();
        this.testCases.put("4408041234567893", true);
        this.testCases.put("4417123456789112", true);
        this.testCases.put("4111111111111111", true);
        this.testCases.put("41111111111111111", false);
        this.testCases.put("411111111111111", false);
        this.testCases.put("378282246310005", false);
        this.testCases.put("6011111111111117", false);
        this.testCases.put("5105105105105100", false);
        this.testCases.put("5105105105105106", false);
        this.testCases.put("9111111111111111", false);
    }

    @Test
    void creditCardValidationMatchesExpectedOutput() {

        testCases.forEach((String cardNumber, Boolean expected) -> {
            assertEquals(expected, visaStrategy.validate(cardNumber));
        });
    }
}
