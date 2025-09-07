package com.example.StatePattern.ConcreteClass;

import com.example.StatePattern.Interface.TrafficLightState;

public class GreenLightState implements TrafficLightState {
    @Override
    public void transition() {
        System.out.println("Transitioning from Green to Yellow");
    }

    @Override
    public void display() {
        System.out.println("Green Light - Go");
    }
}
