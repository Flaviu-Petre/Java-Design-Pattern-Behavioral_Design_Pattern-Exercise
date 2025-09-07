package com.example.CommandPattern.ReceiverClasses;

public class Thermostat {
    private int temperature;

    public Thermostat() {
        this.temperature = 20; // Default temperature
    }

    public void increaseTemperature() {
        temperature++;
        System.out.println("Thermostat temperature increased to " + temperature + "°C");
    }

    public void decreaseTemperature() {
        temperature--;
        System.out.println("Thermostat temperature decreased to " + temperature + "°C");
    }
}
