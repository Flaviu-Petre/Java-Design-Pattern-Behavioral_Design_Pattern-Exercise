package com.example.CommandPattern.ConcreteCommandClasses;

import com.example.CommandPattern.ReceiverClasses.Fan;

public class DecreaseFanSpeedCommand {
    private Fan fan;

    public DecreaseFanSpeedCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.decreaseSpeed();
    }
}
