package com.example.StatePattern.ConcreteClass;

import com.example.StatePattern.Interface.TrafficLightState;

public class YellowLightState implements TrafficLightState {

    @Override
    public void transition() {
        System.out.println("Transitioning from Yellow to Red");
    }

    @Override
    public void display() {
        System.out.println("Yellow Light - Caution");
    }
}
