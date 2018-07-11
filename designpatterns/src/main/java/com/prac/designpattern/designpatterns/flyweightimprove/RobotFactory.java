package com.prac.designpattern.designpatterns.flyweightimprove;

import java.util.HashMap;
import java.util.Map;

public class RobotFactory {

    Map<String, IRobot> shapes = new HashMap<>();

    public int totalObjectsCreated() {
        return shapes.size();
    }

    public IRobot getRobotFromFactory(String robotCategory) throws Exception {

        IRobot robot = null;
        if (shapes.containsKey(robotCategory)) {
            return shapes.get(robotCategory);
        } else {
            switch (robotCategory) {
                case "King":
                    System.out.println("\nWe do not have King Robot. So we are creating a King Robot now");
                    robot = new Robot("King");
                    shapes.put(robotCategory, robot);

                    break;
                case "Queen":
                    System.out.println("\nWe do not have Queen Robot. So we are creating a Queen Robot now.");
                    robot = new Robot("Queen");
                    shapes.put(robotCategory, robot);
                    break;
                default:
                    throw new Exception(" Robot Factory can create only small and big shapes");
            }
        }
        return robot;
    }
}
