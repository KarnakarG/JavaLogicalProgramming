package com.prac.designpattern.designpatterns.builder;

public class BuilderPattern {
    public static void main(String[] args) {

        System.out.println("*** Builder Pattern ***");
        Director director = new Director();

        System.out.println("\n*** Car Builder ***");
        IBuilder carbuilder = new Car();
        director.build(carbuilder);
        Product p1 = carbuilder.getVehicle();
        p1.show();

        System.out.println("\n*** Moter Cycle Builder Builder ***");
        IBuilder motorBuilder = new MoterCycle();
        director.build(motorBuilder);
        Product p2 = motorBuilder.getVehicle();
        p2.show();
    }
}

