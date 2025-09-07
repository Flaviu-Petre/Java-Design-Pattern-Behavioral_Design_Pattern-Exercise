package com.example.CommandPattern.ConcreteCommandClasses;

import com.example.CommandPattern.Command;
import com.example.CommandPattern.ReceiverClasses.Light;

public class TurnOffLightCommand implements Command {
    private Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
