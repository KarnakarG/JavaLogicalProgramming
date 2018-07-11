package com.prac.designpattern.designpatterns.flyweightimprove;

import java.util.Random;

public class FlyWeightPattern {

    public static void main(String[] args) throws Exception {

        System.out.println("*** FlyWeight Pattern Demo ***");

        RobotFactory factory = new RobotFactory();
        Robot shape;
        for (int i = 0; i < 5; i++) {
            shape = (Robot) factory.getRobotFromFactory("King");
            shape.setColorOfRobot(getRandomColor());
            shape.print();

        }
        int numOfDistinctRobots = factory.totalObjectsCreated();

        System.out.println("\nDistinct Robot objects created till now= " + numOfDistinctRobots);

        for (int i = 0; i < 5; i++) {
            shape = (Robot) factory.getRobotFromFactory("Queen");
            shape.setColorOfRobot(getRandomColor());
            shape.print();
        }
        numOfDistinctRobots = factory.totalObjectsCreated();
        System.out.println("\nDistinct Robot objects created till now= " + numOfDistinctRobots);

    }

    static String getRandomColor() {
        Random r = new Random();
        int random = r.nextInt(20);
        if (random % 2 == 0) {
            return "red";
        } else {
            return "green";
        }
    }
}
