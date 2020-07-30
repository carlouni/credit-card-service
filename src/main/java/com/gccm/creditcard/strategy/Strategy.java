package com.gccm.creditcard.strategy;

/**
 * Defines the contract for implementing validation strategies. Any new vendor
 * validation should implement this interface.
 */
public interface Strategy {

    /**
     * Returns the strategy name.
     * @return String
     */
    public String getName();

    /**
     * Returns true if cardNumber passed the validation strategy. It
     * return false otherwise.
     * @param cardNumber should contain only digits without empty spaces.
     * @return boolean
     */
    public boolean validate(String cardNumber);
}
