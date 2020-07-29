package com.gccm.creditcard.model;

/**
 * Contract for returning validation results to the client.
 */
public class ValidationResult {
    private String cardNumber;
    private String vendor;
    private String status;

    private ValidationResult() {
    }

    public ValidationResult(String cardNumber, String vendor, String status) {
        this.cardNumber = cardNumber;
        this.vendor = vendor;
        this.status = status;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
