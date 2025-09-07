package com.example.CommandPattern.ConcreteCommandClasses;

import com.example.CommandPattern.ReceiverClasses.Thermostat;

public class DecreaseTemperatureSpeedCommand {
    private Thermostat temperature;

    public DecreaseTemperatureSpeedCommand(Thermostat temperature) {
        this.temperature = temperature;
    }

    public void execute() {
        temperature.decreaseTemperature();
    }
}
