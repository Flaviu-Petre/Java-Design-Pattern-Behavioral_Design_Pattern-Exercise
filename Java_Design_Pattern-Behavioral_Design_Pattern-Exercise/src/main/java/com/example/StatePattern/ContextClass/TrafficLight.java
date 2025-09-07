package com.example.StatePattern.ContextClass;

import com.example.StatePattern.ConcreteClass.GreenLightState;
import com.example.StatePattern.ConcreteClass.RedLightState;
import com.example.StatePattern.ConcreteClass.YellowLightState;
import com.example.StatePattern.Interface.TrafficLightState;

public class TrafficLight {
    private TrafficLightState currentState;

    public TrafficLight() {
        this.currentState = new RedLightState();
    }

    public TrafficLightState getState() {
        return currentState;
    }

    public String getCurrentStateName() {
        return currentState.getClass().getSimpleName();
    }

    public void nextState() {
        System.out.println("Current state: " + getCurrentStateName());

        currentState.transition();

        if (currentState instanceof RedLightState) {
            this.currentState = new GreenLightState();
        } else if (currentState instanceof GreenLightState) {
            this.currentState = new YellowLightState();
        } else if (currentState instanceof YellowLightState) {
            this.currentState = new RedLightState();
        }

        System.out.println("New state: " + getCurrentStateName());
    }

    public void displayCurrentState() {
        currentState.display();
    }

    public void operate() {
        displayCurrentState();
        nextState();
        System.out.println(); // Add spacing for readability
    }
}
