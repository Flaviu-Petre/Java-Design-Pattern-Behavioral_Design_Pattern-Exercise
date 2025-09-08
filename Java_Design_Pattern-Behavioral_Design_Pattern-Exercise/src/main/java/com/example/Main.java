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
import com.example.ObserverDesignPattern.WeatherObserver;
import com.example.ObserverDesignPattern.WeatherStation;
import com.example.StatePattern.ContextClass.TrafficLight;
import com.example.StrategyPattern.ConcreteClasses.BankTransferPaymentStrategy;
import com.example.StrategyPattern.ConcreteClasses.CreditCardPaymentStrategy;
import com.example.StrategyPattern.ConcreteClasses.PayPalPaymentStrategy;
import com.example.StrategyPattern.PaymentStrategy;
import com.example.StrategyPattern.ShoppingCart;
import com.example.TemplateMethodPattern.AbstractClass.ReportTemplate;
import com.example.TemplateMethodPattern.ConcreteClasses.FinancialReport;
import com.example.TemplateMethodPattern.ConcreteClasses.InventoryReport;
import com.example.TemplateMethodPattern.ConcreteClasses.SalesReport;

public class Main {
    public static void main(String[] args) {
        //ChainOfResponsibilityPattern();
        //CommandPattern();
        //InterpreterPattern();
        //IteratorPattern();
        //MediatorPattern();
        //ObserverPattern();
        //StatePattern();
        //StrategyPattern();
        TemplateMethodPattern();
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

    private static void ObserverPattern() {
        System.out.println("=== Observer Pattern Test ===\n");

        WeatherStation weatherStation = new WeatherStation();

        System.out.println("Creating weather observers:\n");

        WeatherObserver mobileApp = new WeatherObserver("Mobile Weather App");
        WeatherObserver desktopWidget = new WeatherObserver("Desktop Widget");
        WeatherObserver webDashboard = new WeatherObserver("Web Dashboard");
        WeatherObserver smartWatch = new WeatherObserver("Smart Watch");

        System.out.println("=== Observer Registration Test ===");
        weatherStation.addObserver(mobileApp);
        weatherStation.addObserver(desktopWidget);
        weatherStation.addObserver(webDashboard);
        weatherStation.addObserver(smartWatch);

        System.out.println("Total observers registered: " + weatherStation.getObserverCount() + "\n");

        System.out.println("=== Weather Update Test ===");
        System.out.println("Updating weather conditions...\n");
        weatherStation.setState(25, 65, 1013);

        System.out.println("\n" + "-".repeat(60) + "\n");

        System.out.println("=== Second Weather Update Test ===");
        System.out.println("Weather conditions changing...\n");
        weatherStation.setState(18, 80, 995);

        System.out.println("\n" + "-".repeat(60) + "\n");

        System.out.println("=== Observer Removal Test ===");
        weatherStation.removeObserver(smartWatch);
        System.out.println("Smart Watch unsubscribed from weather updates.");
        System.out.println("Remaining observers: " + weatherStation.getObserverCount() + "\n");

        System.out.println("Updating weather after removal...\n");
        weatherStation.setState(30, 45, 1020);

        System.out.println("\n" + "-".repeat(60) + "\n");

        System.out.println("=== Duplicate Observer Prevention Test ===");
        weatherStation.addObserver(smartWatch);
        System.out.println("Smart Watch re-subscribed.");

        System.out.println("Attempting to add Smart Watch again (should prevent duplicate):");
        weatherStation.addObserver(smartWatch);
        System.out.println("Total observers: " + weatherStation.getObserverCount() + "\n");

        System.out.println("=== Final Weather Update Test ===");
        System.out.println("Final weather update...\n");
        weatherStation.setState(22, 70, 1008);

        System.out.println("\n" + "-".repeat(60) + "\n");

        System.out.println("=== Remove All Observers Test ===");
        weatherStation.removeObserver(mobileApp);
        weatherStation.removeObserver(desktopWidget);
        weatherStation.removeObserver(webDashboard);
        weatherStation.removeObserver(smartWatch);

        System.out.println("All observers removed. Remaining: " + weatherStation.getObserverCount());
        System.out.println("Updating weather with no observers...\n");
        weatherStation.setState(15, 90, 980);

        System.out.println("No observers were notified (as expected).\n");

        System.out.println("=== Observer Pattern Test Complete ===");
    }

    private static void StatePattern() {
        System.out.println("=== State Pattern Test ===\n");

        TrafficLight trafficLight = new TrafficLight();

        System.out.println("=== Initial State Test ===");
        System.out.println("Traffic light starts in: " + trafficLight.getCurrentStateName());
        trafficLight.displayCurrentState();
        System.out.println();

        System.out.println("=== Individual State Transitions ===");

        System.out.println("1. First transition:");
        trafficLight.nextState();
        trafficLight.displayCurrentState();
        System.out.println();

        System.out.println("2. Second transition:");
        trafficLight.nextState();
        trafficLight.displayCurrentState();
        System.out.println();

        System.out.println("3. Third transition:");
        trafficLight.nextState();
        trafficLight.displayCurrentState();
        System.out.println();

        System.out.println("-".repeat(50) + "\n");

        System.out.println("=== Complete Cycle Test ===");
        System.out.println("Running through a complete traffic light cycle:\n");

        for (int i = 1; i <= 3; i++) {
            System.out.println("Cycle step " + i + ":");
            trafficLight.operate();
        }

        System.out.println("=== Verification Test ===");
        System.out.println("After complete cycle, back to: " + trafficLight.getCurrentStateName());
        trafficLight.displayCurrentState();
        System.out.println();

        System.out.println("=== State Pattern Test Complete ===");
    }

    private static void StrategyPattern() {
        System.out.println("=== Strategy Pattern Test ===\n");

        ShoppingCart cart = new ShoppingCart();
        double purchaseAmount = 299.99;

        System.out.println("Testing different payment strategies for amount: $" + purchaseAmount + "\n");

        System.out.println("=== Credit Card Payment Test ===");
        PaymentStrategy creditCardStrategy = new CreditCardPaymentStrategy("**** **** **** 1234");
        cart.setPaymentStrategy(creditCardStrategy);
        cart.checkout(purchaseAmount);
        System.out.println();

        System.out.println("=== PayPal Payment Test ===");
        PaymentStrategy paypalStrategy = new PayPalPaymentStrategy("user@example.com");
        cart.setPaymentStrategy(paypalStrategy);
        cart.checkout(purchaseAmount);
        System.out.println();

        System.out.println("=== Bank Transfer Payment Test ===");
        PaymentStrategy bankTransferStrategy = new BankTransferPaymentStrategy("ACC-123456789");
        cart.setPaymentStrategy(bankTransferStrategy);
        cart.checkout(purchaseAmount);
        System.out.println();

        System.out.println("-".repeat(60) + "\n");

        System.out.println("=== Runtime Strategy Switching Test ===");
        System.out.println("Processing multiple purchases with different payment methods:\n");

        double[] amounts = {49.99, 129.50, 75.25};
        PaymentStrategy[] strategies = {
                new CreditCardPaymentStrategy("**** **** **** 5678"),
                new PayPalPaymentStrategy("customer@shop.com"),
                new BankTransferPaymentStrategy("ACC-987654321")
        };
        String[] strategyNames = {"Credit Card", "PayPal", "Bank Transfer"};

        for (int i = 0; i < amounts.length; i++) {
            System.out.println("Purchase " + (i + 1) + " - Using " + strategyNames[i] + ":");
            cart.setPaymentStrategy(strategies[i]);
            cart.checkout(amounts[i]);
            System.out.println();
        }

        System.out.println("-".repeat(60) + "\n");

        System.out.println("=== Polymorphic Behavior Test ===");
        System.out.println("Demonstrating that all strategies implement the same interface:\n");

        PaymentStrategy[] allStrategies = {
                new CreditCardPaymentStrategy("**** **** **** 9999"),
                new PayPalPaymentStrategy("test@polymorphism.com"),
                new BankTransferPaymentStrategy("ACC-POLY123")
        };

        double testAmount = 100.00;

        for (int i = 0; i < allStrategies.length; i++) {
            System.out.println("Strategy " + (i + 1) + " (" + allStrategies[i].getClass().getSimpleName() + "):");
            allStrategies[i].processPayment(testAmount);
            System.out.println();
        }

        System.out.println("\n=== Strategy Pattern Test Complete ===");
    }

    private static void TemplateMethodPattern() {
        System.out.println("=== Template Method Pattern Test ===\n");

        System.out.println("Testing different report types using the same template algorithm:\n");

        System.out.println("=== Financial Report Generation ===");
        ReportTemplate financialReport = new FinancialReport();
        System.out.println("Generating Financial Report:");
        financialReport.generateReport();
        System.out.println("Financial report completed\n");

        System.out.println("-".repeat(50) + "\n");

        System.out.println("=== Sales Report Generation ===");
        ReportTemplate salesReport = new SalesReport();
        System.out.println("Generating Sales Report:");
        salesReport.generateReport();
        System.out.println("Sales report completed\n");

        System.out.println("-".repeat(50) + "\n");

        System.out.println("=== Inventory Report Generation ===");
        ReportTemplate inventoryReport = new InventoryReport();
        System.out.println("Generating Inventory Report:");
        inventoryReport.generateReport();
        System.out.println("Inventory report completed\n");

        System.out.println("-".repeat(50) + "\n");

        System.out.println("=== Polymorphic Behavior Test ===");
        System.out.println("Processing multiple report types using the same template method:\n");

        ReportTemplate[] reports = {
                new FinancialReport(),
                new SalesReport(),
                new InventoryReport()
        };

        String[] reportNames = {"Financial", "Sales", "Inventory"};

        for (int i = 0; i < reports.length; i++) {
            System.out.println("Processing " + reportNames[i] + " Report:");
            reports[i].generateReport();
            System.out.println();
        }

        System.out.println("-".repeat(50) + "\n");

        System.out.println("=== Template Method Algorithm Verification ===");

        financialReport.generateReport();
        System.out.println();


        System.out.println("\n=== Template Method Pattern Test Complete ===");
    }
}