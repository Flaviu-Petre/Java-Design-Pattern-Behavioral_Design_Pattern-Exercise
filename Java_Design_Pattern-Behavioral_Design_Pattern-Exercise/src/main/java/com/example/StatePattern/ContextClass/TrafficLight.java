package com.example.StatePattern.ContextClass;

import com.example.StatePattern.Interface.TrafficLightState;

public class TrafficLight {
    private TrafficLightState state;

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public TrafficLightState getState() {
        return state;
    }

    public void performStateTransition(){
        state.transition();
    }

    public void displayCurrentState(){
        state.display();
    }
}
