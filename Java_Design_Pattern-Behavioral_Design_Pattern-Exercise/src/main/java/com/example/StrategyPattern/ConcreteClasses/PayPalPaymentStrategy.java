package com.example.StrategyPattern.ConcreteClasses;

import com.example.StrategyPattern.PaymentStrategy;

public class PayPalPaymentStrategy implements PaymentStrategy {
    private String email;

    public PayPalPaymentStrategy(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid " + amount + " using PayPal account: " + email);
    }
}
