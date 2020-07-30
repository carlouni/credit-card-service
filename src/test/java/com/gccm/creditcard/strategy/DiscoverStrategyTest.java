package com.gccm.creditcard.strategy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DiscoverStrategyTest {

    private final DiscoverStrategy discoverStrategy;
    private final Map<String, Boolean> testCases;

    @Autowired
    public DiscoverStrategyTest(DiscoverStrategy discoverStrategy) {
        this.discoverStrategy = discoverStrategy;
        this.testCases = new HashMap<>();
        this.testCases.put("6011111111111117", true);
        this.testCases.put("6011000990139424", true);
        this.testCases.put("60110009901394241", false);
        this.testCases.put("60100009901394241", false);
        this.testCases.put("4111111111111111", false);
        this.testCases.put("4012888888881881", false);
    }

    @Test
    void creditCardValidationMatchesExpectedOutput() {

        testCases.forEach((String cardNumber, Boolean expected) -> {
            assertEquals(discoverStrategy.validate(cardNumber), expected);
        });
    }
}
