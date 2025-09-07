package com.example;

import com.example.ChainofResponsibilityPattern.ComplexityLevel;
import com.example.ChainofResponsibilityPattern.ConcreteClasses.AdvancedSupportHandler;
import com.example.ChainofResponsibilityPattern.ConcreteClasses.BasicSupportHandler;
import com.example.ChainofResponsibilityPattern.ConcreteClasses.IntermediateSupportHandler;
import com.example.ChainofResponsibilityPattern.Interface.SupportHandler;
import com.example.ChainofResponsibilityPattern.SupportTicket;
import com.example.CommandPattern.Command;
import com.example.CommandPattern.ConcreteCommandClasses.TurnOffLightCommand;
import com.example.CommandPattern.ConcreteCommandClasses.TurnOnLightCommand;
import com.example.CommandPattern.Invoker.RemoteControlInvoker;
import com.example.CommandPattern.ReceiverClasses.Fan;
import com.example.CommandPattern.ReceiverClasses.Light;
import com.example.CommandPattern.ReceiverClasses.Thermostat;
import com.example.InterpreterPattern.Interface.Expression;
import com.example.InterpreterPattern.ParserClass.ExpressionParser;
import com.example.IteratorPattern.Collection.PlaylistCollection;
import com.example.IteratorPattern.Interface.Iterator;
import com.example.IteratorPattern.Song;
import com.example.MediatorPattern.ChatRoomMediator;
import com.example.MediatorPattern.Participant;

public class Main {
    public static void main(String[] args) {
        //ChainOfResponsibilityPattern();
        //CommandPattern();
        //InterpreterPattern();
        //IteratorPattern();
        MediatorPattern();
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

    private static void CommandPattern() {
        System.out.println("=== Command Pattern Test ===\n");

        Light livingRoomLight = new Light();
        Fan ceilingFan = new Fan();
        Thermostat thermostat = new Thermostat();

        RemoteControlInvoker remote = new RemoteControlInvoker();

        System.out.println("Testing Light Control Commands:\n");

        Command turnOnLight = new TurnOnLightCommand(livingRoomLight);
        Command turnOffLight = new TurnOffLightCommand(livingRoomLight);

        System.out.println("Pressing button to turn ON light:");
        remote.setCommand(turnOnLight);
        remote.pressButton();

        System.out.println("Pressing button to turn OFF light:");
        remote.setCommand(turnOffLight);
        remote.pressButton();

        System.out.println("\n" + "-".repeat(40) + "\n");


        System.out.println("Testing Fan Control Commands:\n");
        System.out.println("Note: Fan commands need to be fixed to implement Command interface");
        System.out.println("Currently testing direct receiver calls:");

        System.out.println("Increasing fan speed:");
        ceilingFan.increaseSpeed();
        ceilingFan.increaseSpeed();
        ceilingFan.increaseSpeed();

        System.out.println("Decreasing fan speed:");
        ceilingFan.decreaseSpeed();

        System.out.println("\n" + "-".repeat(40) + "\n");

        System.out.println("Testing Thermostat Control Commands:\n");
        System.out.println("Note: Thermostat commands need to be fixed to implement Command interface");
        System.out.println("Currently testing direct receiver calls:");

        System.out.println("Adjusting temperature:");
        thermostat.increaseTemperature();
        thermostat.increaseTemperature();
        thermostat.decreaseTemperature();

        System.out.println("=== Command Pattern Test Complete ===");
    }

    private static void InterpreterPattern() {
        System.out.println("=== Interpreter Pattern Test ===\n");

        // Create the parser
        ExpressionParser parser = new ExpressionParser();

        // Test cases with different arithmetic expressions
        String[] testExpressions = {
                "5",
                "10 + 3",
                "15 - 7",
                "4 * 6",
                "20 / 4",
                "10 + 5 - 3",
                "2 * 3 + 4",
                "20 / 4 + 3",
                "15 - 3 * 2",
                "100 / 10 - 5"
        };

        System.out.println("Testing various arithmetic expressions:\n");

        for (String expr : testExpressions) {
            try {
                System.out.println("Expression: " + expr);

                Expression parsedExpression = parser.parse(expr);

                // Interpret the expression to get the result
                int result = parsedExpression.interpret();

                System.out.println("Result: " + result);
                System.out.println("Evaluation: " + expr + " = " + result);
                System.out.println("-".repeat(30));

            } catch (Exception e) {
                System.out.println("Error parsing expression '" + expr + "': " + e.getMessage());
                System.out.println("-".repeat(30));
            }
        }

        System.out.println("=== Interpreter Pattern Test Complete ===");
    }

    private static void IteratorPattern() {
        System.out.println("=== Iterator Pattern Test ===\n");

        PlaylistCollection myPlaylist = new PlaylistCollection();

        System.out.println("Creating playlist and adding songs:\n");

        Song[] songs = {
                new Song("Bohemian Rhapsody", "Queen"),
                new Song("Hotel California", "Eagles"),
                new Song("Stairway to Heaven", "Led Zeppelin"),
                new Song("Sweet Child O' Mine", "Guns N' Roses"),
                new Song("Imagine", "John Lennon"),
                new Song("Billie Jean", "Michael Jackson")
        };

        for (Song song : songs) {
            myPlaylist.addSong(song);
            System.out.println("Added: " + song);
        }

        System.out.println("\nPlaylist created with " + myPlaylist.size() + " songs.\n");

        System.out.println("=== Basic Iteration Test ===");
        System.out.println("Playing all songs in the playlist:\n");

        Iterator<Song> iterator = myPlaylist.getIterator();
        int songNumber = 1;

        while (iterator.hasNext()) {
            Song currentSong = iterator.next();
            System.out.println(songNumber + ". Now playing: " + currentSong);
            songNumber++;
        }

        System.out.println("=== Iterator Pattern Test Complete ===");
    }

    private static void MediatorPattern() {
        System.out.println("=== Mediator Pattern Test ===\n");

        ChatRoomMediator chatRoom = new ChatRoomMediator();

        System.out.println("Creating chat room participants:\n");

        Participant alice = new Participant("Alice", chatRoom);
        Participant bob = new Participant("Bob", chatRoom);
        Participant charlie = new Participant("Charlie", chatRoom);
        Participant diana = new Participant("Diana", chatRoom);

        chatRoom.adduser(alice);
        chatRoom.adduser(bob);
        chatRoom.adduser(charlie);
        chatRoom.adduser(diana);

        System.out.println("\nChat room now has " + chatRoom.getUserCount() + " participants.\n");

        alice.sendMessage("Hello everyone!");
        System.out.println();

        bob.sendMessage("Hi Alice! How are you?");
        System.out.println();

        charlie.sendMessage("Good morning all!");
        System.out.println();

        System.out.println("-".repeat(50) + "\n");

        System.out.println("=== Self-Message Prevention Test ===");
        System.out.println("Testing that senders don't receive their own messages:");
        diana.sendMessage("This message should not echo back to Diana");
        System.out.println();

        System.out.println("-".repeat(50) + "\n");

        // Test removing a participant
        System.out.println("=== Participant Removal Test ===");
        chatRoom.removeUser(charlie);
        System.out.println("Participants remaining: " + chatRoom.getUserCount());
        System.out.println("\nSending message after Charlie left:");
        alice.sendMessage("Charlie won't receive this message");
        System.out.println();

        System.out.println("-".repeat(50) + "\n");

        // Test multiple messages in conversation
        System.out.println("=== Conversation Flow Test ===");
        System.out.println("Simulating a natural conversation:");
        bob.sendMessage("What's everyone up to today?");
        System.out.println();

        diana.sendMessage("I'm working on some coding projects");
        System.out.println();

        alice.sendMessage("Same here! Learning design patterns");
        System.out.println();

        bob.sendMessage("That's great! Which pattern are you studying?");
        System.out.println();

        alice.sendMessage("Currently working on the Mediator pattern");
        System.out.println();

        System.out.println("=== Mediator Pattern Test Complete ===");
    }
}