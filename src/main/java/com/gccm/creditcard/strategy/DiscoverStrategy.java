package com.gccm.creditcard.strategy;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class DiscoverStrategy implements Strategy  {
    private final String name = "Discover";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean validate(String cardNumber) {

        return Pattern
                .compile("^6011[0-9]{12}$")
                .matcher(cardNumber)
                .matches();
    }
}
