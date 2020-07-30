package com.gccm.creditcard.strategy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LuhnStrategyTest {

    private final LuhnStrategy luhnStrategy;
    private final Map<String, Boolean> testCases;

    @Autowired
    public LuhnStrategyTest(LuhnStrategy luhnStrategy) {
        this.luhnStrategy = luhnStrategy;
        this.testCases = new HashMap<>();

        // Assumes previous vendor sanity checks was made.
        this.testCases.put("4408041234567893", true);
        this.testCases.put("4111111111111111", true);
        this.testCases.put("4012888888881881", true);
        this.testCases.put("378282246310005", true);
        this.testCases.put("5105105105105100", true);
        this.testCases.put("6011111111111117", true);
        this.testCases.put("4417123456789112", false);
        this.testCases.put("4111111111111", false);
        this.testCases.put("5105105105105106", false);
    }

    @Test
    void creditCardValidationMatchesExpectedOutput() {

        testCases.forEach((String cardNumber, Boolean expected) -> {
            assertEquals(luhnStrategy.validate(cardNumber), expected);
        });
    }
}

