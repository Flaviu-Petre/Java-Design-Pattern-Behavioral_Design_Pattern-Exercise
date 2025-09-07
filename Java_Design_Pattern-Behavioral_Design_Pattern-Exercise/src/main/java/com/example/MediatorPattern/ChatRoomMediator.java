package com.example.MediatorPattern;

import java.util.List;

public class ChatRoomMediator implements ChatMediator{

    private List<Participant> users;

    public ChatRoomMediator(List<Participant> users) {
        this.users = users;
    }

    @Override
    public void sendMessage(String message, Participant participant) {
        for (Participant user : users) {
            if (user != participant) {
                user.sendMessage(message);
            }
        }
    }

    @Override
    public void adduser(Participant participant) {
        users.add(participant);
    }

}
