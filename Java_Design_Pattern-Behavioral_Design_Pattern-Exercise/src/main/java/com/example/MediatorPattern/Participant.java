package com.example.MediatorPattern;

public class Participant {
    private String name;
    private ChatRoomMediator chatRoom;

    public Participant(String name, ChatRoomMediator chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        System.out.println(this.name + " sends: " + message);
    }

}
