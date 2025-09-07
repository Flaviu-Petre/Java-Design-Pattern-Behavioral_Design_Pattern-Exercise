package com.example;

import com.example.ChainofResponsibilityPattern.ComplexityLevel;
import com.example.ChainofResponsibilityPattern.ConcreteClasses.AdvancedSupportHandler;
import com.example.ChainofResponsibilityPattern.ConcreteClasses.BasicSupportHandler;
import com.example.ChainofResponsibilityPattern.ConcreteClasses.IntermediateSupportHandler;
import com.example.ChainofResponsibilityPattern.Interface.SupportHandler;
import com.example.ChainofResponsibilityPattern.SupportTicket;

public class Main {
    public static void main(String[] args) {
        ChainOfResponsibilityPattern();
    }

    private static void ChainOfResponsibilityPattern() {
        System.out.println("=== Chain of Responsibility Pattern Test ===\n");

        SupportHandler basicHandler = new BasicSupportHandler();
        SupportHandler intermediateHandler = new IntermediateSupportHandler();
        SupportHandler advancedHandler = new AdvancedSupportHandler();

        basicHandler.setNextHandler(intermediateHandler);
        intermediateHandler.setNextHandler(advancedHandler);

        SupportTicket basicTicket = new SupportTicket(
                ComplexityLevel.Basic,
                "Password reset request"
        );

        SupportTicket intermediateTicket = new SupportTicket(
                ComplexityLevel.Intermediate,
                "Software installation issue"
        );

        SupportTicket advancedTicket = new SupportTicket(
                ComplexityLevel.Advanced,
                "Database corruption and recovery"
        );

        System.out.println("Processing tickets through the support chain:\n");

        System.out.println("1. Processing Basic Ticket:");
        System.out.println("Issue: " + basicTicket.getIssueDescription());
        basicHandler.handleRequest(basicTicket);
        System.out.println();

        System.out.println("2. Processing Intermediate Ticket:");
        System.out.println("Issue: " + intermediateTicket.getIssueDescription());
        basicHandler.handleRequest(intermediateTicket);
        System.out.println();

        System.out.println("3. Processing Advanced Ticket:");
        System.out.println("Issue: " + advancedTicket.getIssueDescription());
        basicHandler.handleRequest(advancedTicket);
        System.out.println();
    }
}