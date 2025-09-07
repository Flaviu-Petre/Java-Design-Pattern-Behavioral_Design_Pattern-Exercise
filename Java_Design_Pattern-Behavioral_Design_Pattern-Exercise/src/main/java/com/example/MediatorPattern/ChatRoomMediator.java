package com.example.MediatorPattern;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomMediator implements ChatMediator{

    private List<Participant> users;

    public ChatRoomMediator() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, Participant sender) {
        for (Participant user : users) {
            if (user != sender) {
                user.receive(message, sender.getName());
            }
        }
    }

    @Override
    public void adduser(Participant participant) {
        users.add(participant);
        System.out.println(participant.getName() + " joined the chat room.");
    }

    public void removeUser(Participant participant) {
        users.remove(participant);
        System.out.println(participant.getName() + " left the chat room.");
    }

    public int getUserCount() {
        return users.size();
    }
}
