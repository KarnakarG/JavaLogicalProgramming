package com.prac.designpattern.designpatterns.flyweight;

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
                case "small":
                    System.out.println("\nWe do not have a small Robot. So we are create small Robot");
                    robot = new SmallRobot();
                    shapes.put(robotCategory, robot);
                    break;
                case "big":
                    System.out.println("\nWe do not have a big robot.So we are creating big robit");
                    robot = new BigRobot();
                    shapes.put(robotCategory, robot);
                    break;
                default:
                    throw new Exception(" Robot Factory can create only small and big shapes");
            }
        }
        return robot;
    }
}
