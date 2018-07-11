package com.prac.designpattern.designpatterns.strategy;

public class FirstChoice implements IChoice{

    @Override
    public void myChoice(String str1, String str2) {

        System.out.println("You want to add two numbers");
        int num1,num2;
        num1 = Integer.parseInt(str1);
        num2 = Integer.parseInt(str2);

        System.out.println("Results of Addition is " + (num1+num2));
        System.out.println("*** End of Strategy Parrtern ***");
    }
}
