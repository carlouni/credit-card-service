package com.gccm.creditcard.model;

import javax.validation.constraints.Pattern;

/**
 * Contract for accepting validation requests from the client
 */
public class ValidationRequest {

    @Pattern(regexp="^[1-9][0-9\\s]*[0-9]$", message = "Must contain valid digits and no blank spaces at the beginning and end.")
    private String cardNumber;

    private ValidationRequest() {
    }

    public ValidationRequest(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
