package com.prac.designpattern.designpatterns.state;

public class On extends RemoteControl {

    @Override
    public void pressSwitch(TV context) {
        System.out.println("I am aleady On, Going to be switched of");
        context.setState(new Off());
    }
}
