package com.prac.designpattern.designpatterns.flyweight;

public class FlyWeightPattern {

    public static void main(String[] args) throws Exception {

        System.out.println("*** FlyWeight Pattern Demo ***");

        RobotFactory factory = new RobotFactory();
        IRobot robot = factory.getRobotFromFactory("small");
        robot.print();
        for (int i = 0; i < 2; i++) {
            robot = factory.getRobotFromFactory("small");
            robot.print();
        }
        int numOfDistinctRobots = factory.totalObjectsCreated();

        System.out.println("Distinct Robot objects created till now= " + numOfDistinctRobots);
        robot = factory.getRobotFromFactory("big");
        robot.print();
        for (int i = 0; i < 5; i++) {
            robot = factory.getRobotFromFactory("big");
            robot.print();
        }
        numOfDistinctRobots = factory.totalObjectsCreated();
        System.out.println("\nDistinct Robot objects created till now= " + numOfDistinctRobots);

    }
}
