package com.prac.designpattern.designpatterns.strategy;

import java.util.Scanner;

public class StrategyPatternEx {

    public static void main(String[] args) {

        System.out.println("***Strategy Pattern Demo***");
        Scanner in = new Scanner(System.in);
        IChoice choice = null;
        Context context = new Context();
        String input1, input2;
        //Looping twice to test two different choices
        try {
            for (int i = 1; i <= 2; i++) {
                System.out.println("Enter an integer:");
                input1 = in.nextLine();
                System.out.println("Enter another integer:");
                input2 = in.nextLine();
                System.out.println("Enter ur choice(1 or 2)");
                System.out.println("Press 1 for Addition, 2 for Concatenation");
                String c = in.nextLine();
                if (c.equals("1")) {
                    choice = new FirstChoice();
                } else {

                    choice = new SecondChoice();
                }

                context.setChoice(choice);
                context.showShoice(input1, input2);
            }
        } finally {
            in.close();
        }
        System.out.println("End of Strategy pattern");
    }
}
