package com.prac.designpattern.designpatterns.state;

public class StatePatternEx {

    public static void main(String[] args) {

        System.out.println("State Pattren");

        Off initialState = new Off();
        TV tv = new TV(initialState);
        tv.pressButton();
        tv.pressButton();
        tv.pressButton();
        tv.pressButton();
        tv.pressButton();
        tv.pressButton();
    }
}
