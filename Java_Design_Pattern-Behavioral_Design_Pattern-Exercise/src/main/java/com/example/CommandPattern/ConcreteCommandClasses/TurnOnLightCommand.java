package com.example.CommandPattern.ConcreteCommandClasses;

import com.example.CommandPattern.Command;
import com.example.CommandPattern.ReceiverClasses.Light;

public class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
