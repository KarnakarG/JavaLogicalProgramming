package com.prac.designpattern.designpatterns.templet;

public class TempletMethodDemo {

    public static void main(String[] args) {

        System.out.println("Templet method pattern demo");

        BasicEngineering engineering = new ComputerEngineering();
        System.out.println("Computer SC papers");
        engineering.papers();
        engineering = new Electronics();

        System.out.println("\n\nElectonics SC papers");
        engineering.papers();
    }
}
