package com.example.ChainofResponsibilityPattern.ConcreteClasses;

import com.example.ChainofResponsibilityPattern.ComplexityLevel;
import com.example.ChainofResponsibilityPattern.Interface.SupportHandler;
import com.example.ChainofResponsibilityPattern.SupportTicket;

public class AdvancedSupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(SupportTicket ticket) {
        if (ticket.getComplexityLevel() == ComplexityLevel.Advanced) {
            System.out.println("AdvancedSupportHandler: Resolved ticket with complexity " + ticket.getComplexityLevel());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(ticket);
        } else {
            System.out.println("AdvancedSupportHandler: No handler available for ticket with complexity " + ticket.getComplexityLevel());
        }
    }
}
