package com.gccm.creditcard.strategy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AmexStrategyTest {

    private final AmexStrategy amexStrategy;
    private final Map<String, Boolean> testCases;

    @Autowired
    public AmexStrategyTest(AmexStrategy amexStrategy) {
        this.amexStrategy = amexStrategy;
        this.testCases = new HashMap<>();
        this.testCases.put("378282246310005", true);
        this.testCases.put("371449635398431", true);
        this.testCases.put("341449635398431", true);
        this.testCases.put("3414496353984311", false);
        this.testCases.put("4111111111111111", false);
        this.testCases.put("4012888888881881", false);
    }

    @Test
    void creditCardValidationMatchesExpectedOutput() {

        testCases.forEach((String cardNumber, Boolean expected) -> {
            assertEquals(amexStrategy.validate(cardNumber), expected);
        });
    }
}
