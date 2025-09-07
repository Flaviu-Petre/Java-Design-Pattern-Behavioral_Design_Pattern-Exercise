package com.example.ObserverDesignPattern;

import com.example.ObserverDesignPattern.Interfaces.Observer;

public class WeatherObserver implements Observer {
    private String observerName;
    private int temperature;
    private int humidity;
    private int pressure;

    public WeatherObserver(String name) {
        this.observerName = name;
    }

    @Override
    public void update(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println(observerName + " - Current conditions: " + temperature + "°C, " + humidity + "% humidity, " + pressure + " hPa");
    }
}
