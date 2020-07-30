package com.gccm.creditcard.strategy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MasterCardStrategyTest {

    private final MasterCardStrategy masterCardStrategy;
    private final Map<String, Boolean> testCases;

    @Autowired
    public MasterCardStrategyTest(MasterCardStrategy masterCardStrategy) {
        this.masterCardStrategy = masterCardStrategy;
        this.testCases = new HashMap<>();
        this.testCases.put("5105105105105100", true);
        this.testCases.put("5105105105105106", true);
        this.testCases.put("5505105105105100", true);
        this.testCases.put("5505105105105106", true);
        this.testCases.put("51051051051051061", false);
        this.testCases.put("5705105105105106", false);
        this.testCases.put("4111111111111111", false);
        this.testCases.put("4012888888881881", false);
    }

    @Test
    void creditCardValidationMatchesExpectedOutput() {

        testCases.forEach((String cardNumber, Boolean expected) -> {
            System.out.println(cardNumber);
            assertEquals(expected, masterCardStrategy.validate(cardNumber));
        });
    }
}
