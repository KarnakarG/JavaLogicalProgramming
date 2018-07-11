package com.prac.designpattern.designpatterns.builder;

public class Car implements IBuilder {

    private Product carProduct = new Product();

    @Override
    public void buildBody() {
        carProduct.add("This is a Boby of car");
    }

    @Override
    public void addHeadLights() {
        carProduct.add("2 Head lights are added");
    }

    @Override
    public void insertWeels() {
        carProduct.add("4 wheels are added");

    }

    public Product getVehicle() {

        return carProduct;
    }
}
