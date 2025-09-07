package com.example.MediatorPattern;

public interface ChatMediator {
    void sendMessage(String message, Participant participant);
    void adduser(Participant participant);
}
