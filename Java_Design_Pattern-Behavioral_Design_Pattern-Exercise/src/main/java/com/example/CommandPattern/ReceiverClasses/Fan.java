package com.example.CommandPattern.ReceiverClasses;

public class Fan {
    private int speed;

    public Fan() {
        this.speed = 0;
    }

    public void increaseSpeed() {
        if (speed < 3) {
            speed++;
            System.out.println("Fan speed increased to: " + speed);
        } else {
            System.out.println("Fan is already at maximum speed.");
        }
    }
    public void decreaseSpeed() {
        if (speed > 0) {
            speed--;
            System.out.println("Fan speed decreased to: " + speed);
        } else {
            System.out.println("Fan is already at minimum speed.");
        }
    }
}
