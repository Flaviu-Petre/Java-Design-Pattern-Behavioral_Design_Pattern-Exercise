package com.example.CommandPattern.ConcreteCommandClasses;

import com.example.CommandPattern.ReceiverClasses.Fan;

public class IncreaseFanSpeedCommand {
    private Fan fan;

    public IncreaseFanSpeedCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.increaseSpeed();
    }
}
