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

public class Main {
    public static void main(String[] args) {
        //ChainOfResponsibilityPattern();
        CommandPattern();
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
}