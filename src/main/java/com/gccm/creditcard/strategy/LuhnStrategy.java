package com.gccm.creditcard.strategy;

import org.springframework.stereotype.Component;

@Component
public class LuhnStrategy implements Strategy {
    private final String name = "Luhn";

    @Override
    public String getName() {
        return name;
    }

    /**
     * Validate cardNumber using Luhn algorithm. It assumes there was some
     * sanity Vendor checks before passing the cardNumber to this method.
     * @param cardNumber should contain only digits without empty spaces.
     * @return
     */
    @Override
    public boolean validate(String cardNumber) {
        char[] digits = cardNumber.toCharArray();
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            // convert to int using ASCII Table
            int digit = (int) digits[(digits.length - 1) - i] - 48;
            if (i % 2 == 0) {
                sum = sum + digit;
            } else {
                int doubled = digit * 2;
                if (doubled > 9) {
                    sum = sum + doubled / 10;
                    sum = sum + doubled % 10;
                } else {
                    sum = sum + doubled;
                }
            }
        }

        // sum needs to be higher than 0 to be valid
        return (sum % 10 == 0);
    }
}
