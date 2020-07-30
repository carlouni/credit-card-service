package com.gccm.creditcard.strategy;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class MasterCardStrategy implements Strategy {
    private final String name = "MasterCard";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean validate(String cardNumber) {

        return Pattern
                .compile("^5[1|5][0-9]{14}$")
                .matcher(cardNumber)
                .matches();
    }
}
