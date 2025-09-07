package com.example.ChainofResponsibilityPattern.ConcreteClasses;

import com.example.ChainofResponsibilityPattern.ComplexityLevel;
import com.example.ChainofResponsibilityPattern.Interface.SupportHandler;
import com.example.ChainofResponsibilityPattern.SupportTicket;

public class BasicSupportHandler implements  SupportHandler{
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(SupportTicket ticket) {
        if (ticket.getComplexityLevel() == ComplexityLevel.Basic) {
            System.out.println("BasicSupportHandler: Resolved ticket with priority " + ticket.getComplexityLevel());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(ticket);
        } else {
            System.out.println("BasicSupportHandler: No handler available for ticket with priority " + ticket.getComplexityLevel());
        }
    }

}
