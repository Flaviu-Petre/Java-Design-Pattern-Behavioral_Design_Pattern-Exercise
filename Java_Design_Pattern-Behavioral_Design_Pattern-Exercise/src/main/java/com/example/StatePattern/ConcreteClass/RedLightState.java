package com.example.StatePattern.ConcreteClass;

import com.example.StatePattern.Interface.TrafficLightState;

public class RedLightState implements TrafficLightState {
    @Override
    public void transition() {
        System.out.println("Transitioning from Red to Green");
    }

    @Override
    public void display() {
        System.out.println("Red Light - Stop");
    }

}
