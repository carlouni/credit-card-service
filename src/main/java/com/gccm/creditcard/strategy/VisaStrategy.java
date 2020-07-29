package com.gccm.creditcard.strategy;

import org.springframework.stereotype.Component;

@Component
public class VisaStrategy implements Strategy {
    private final String name = "VISA";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean validate(String cardNumber) {

        // TODO: needs implementation
        return true;
    }
}
