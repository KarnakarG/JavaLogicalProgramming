package com.prac.designpattern.designpatterns.builder;

public interface IBuilder {

    void buildBody();

    void insertWeels();

    void addHeadLights();

    Product getVehicle();
}
