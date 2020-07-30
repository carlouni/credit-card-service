package com.gccm.creditcard.strategy;

/**
 * Defines the contract for implementing validation strategies.
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
     * @param cardNumber
     * @return boolean
     */
    public boolean validate(String cardNumber);
}