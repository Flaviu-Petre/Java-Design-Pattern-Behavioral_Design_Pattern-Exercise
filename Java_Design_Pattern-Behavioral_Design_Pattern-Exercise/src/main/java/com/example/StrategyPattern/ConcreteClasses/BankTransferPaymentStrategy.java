package com.example.StrategyPattern.ConcreteClasses;

import com.example.StrategyPattern.PaymentStrategy;

public class BankTransferPaymentStrategy implements PaymentStrategy {
    private String bankAccount;

    public BankTransferPaymentStrategy(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid " + amount + " using Bank Transfer from account: " + bankAccount);
    }
}
