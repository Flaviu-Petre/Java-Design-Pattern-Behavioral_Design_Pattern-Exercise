package com.example.CommandPattern.ConcreteCommandClasses;

import com.example.CommandPattern.ReceiverClasses.Thermostat;

public class IncreaseTemperatureSpeedCommand {
    private Thermostat thermostat;

    public IncreaseTemperatureSpeedCommand(Thermostat thermostat) {
        this.thermostat = thermostat;
    }

    public void execute() {
        thermostat.increaseTemperature();
    }
}
