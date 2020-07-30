package com.gccm.creditcard.strategy;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class AmexStrategy implements Strategy  {
    private final String name = "AMEX";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean validate(String cardNumber) {

        return Pattern
                .compile("^3[4|7][0-9]{13}$")
                .matcher(cardNumber)
                .matches();
    }
}
