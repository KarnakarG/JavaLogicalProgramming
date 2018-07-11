package com.prac.designpattern.designpatterns.builder;

public class MoterCycle implements IBuilder {

    private Product cycleProduct = new Product();

    @Override
    public void buildBody() {
        cycleProduct.add("This is a Boby of MoterCycle");
    }

    @Override
    public void addHeadLights() {
        cycleProduct.add("1 Head light added");
    }

    @Override
    public void insertWeels() {
        cycleProduct.add("2 wheels are added");
    }

    public Product getVehicle() {

        return cycleProduct;
    }
}
