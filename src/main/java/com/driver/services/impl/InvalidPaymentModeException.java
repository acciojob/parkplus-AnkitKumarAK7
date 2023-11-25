package com.driver.services.impl;

public class InvalidPaymentModeException extends RuntimeException {
    public InvalidPaymentModeException(String msg) {
        super(msg);
    }
}
