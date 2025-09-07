package com.example.ObserverDesignPattern;

import com.example.ObserverDesignPattern.Interfaces.Observer;
import com.example.ObserverDesignPattern.Interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {

    private List<Observer> observers;
    private int temperature;
    private int humidity;
    private int pressure;

    public WeatherStation() {
        this.observers = new ArrayList<>();
    }

    public int getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public int getObserverCount() {
        return observers.size();
    }

    @Override
    public void addObserver(Observer observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
            System.out.println("Observer added to weather station.");
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers.remove(observer)) {
            System.out.println("Observer removed from weather station.");
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void setState(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        System.out.println("Weather Station: New weather data received - " +
                temperature + "C, " + humidity + "% humidity, " + pressure + " hPa");

        notifyObservers();
    }


}
