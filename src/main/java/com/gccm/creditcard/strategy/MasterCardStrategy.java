package com.gccm.creditcard.strategy;

import org.springframework.stereotype.Component;

@Component
public class MasterCardStrategy implements Strategy {
    private final String name = "MasterCard";

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
