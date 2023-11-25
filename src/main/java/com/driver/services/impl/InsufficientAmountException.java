package com.driver.services.impl;

public class InsufficientAmountException extends RuntimeException {
    public InsufficientAmountException(String insufficient_amount)  {
        super(insufficient_amount);
    }
}
