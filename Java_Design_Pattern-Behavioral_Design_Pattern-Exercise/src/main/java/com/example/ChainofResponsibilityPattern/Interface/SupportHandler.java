package com.example.ChainofResponsibilityPattern.Interface;

import com.example.ChainofResponsibilityPattern.SupportTicket;

public interface SupportHandler {
    void handleRequest(SupportTicket ticket);
    void setNextHandler(SupportHandler nextHandler);
}
