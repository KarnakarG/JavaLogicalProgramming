package com.prac.designpattern.designpatterns.state;

public class Off extends RemoteControl {

    @Override
    public void pressSwitch(TV context) {
        System.out.println("I am Off, Going to ON...");
        context.setState(new On());

    }
}
