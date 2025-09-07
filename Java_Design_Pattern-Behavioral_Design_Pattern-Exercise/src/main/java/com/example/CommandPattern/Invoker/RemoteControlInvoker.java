package com.example.CommandPattern.Invoker;

import com.example.CommandPattern.Command;

public class RemoteControlInvoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
