package com.prac.designpattern.designpatterns.builder;

public class Director {

    IBuilder mybuilder;

    // A series of steps for production
    public void build(IBuilder builder) {
        mybuilder = builder;
        mybuilder.buildBody();
        mybuilder.addHeadLights();
        mybuilder.insertWeels();

    }
}
