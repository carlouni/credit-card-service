package com.gccm.creditcard.strategy;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class VisaStrategy implements Strategy {
    private final String name = "VISA";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean validate(String cardNumber) {

        return Pattern
                .compile("^4([0-9]{12}|[0-9]{15})$")
                .matcher(cardNumber)
                .matches();
    }
}
