package com.gccm.creditcard.strategy;

import org.springframework.stereotype.Component;

@Component
public class AmexStrategy implements Strategy  {
    private final String name = "AMEX";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean validate(String cardNumber) {

        // TODO: needs implementation
        return false;
    }
}
