package com.epam.practice.practice.threads;

import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Integer> f;
        Future<Double> f2;
        Future<Integer> f3;

        System.out.println("Starting");

        f = es.submit(new Sum(10));
        f3 = es.submit(new Factorial(5));
        f2 = es.submit(new Hypot(3, 4));


        try {
            System.out.println("Integer : " + f.get());
            System.out.println("Time " +f.get(10, TimeUnit.MILLISECONDS));
             System.out.println("Integer... : " + f3.get());
            System.out.println("Double : " + f2.get());
        } catch (InterruptedException exc) {
            System.out.println(exc);
        } catch (ExecutionException exc) {
            System.out.println(exc);
        }
        catch(Exception e){
            System.out.println(e);
        }
        es.shutdown();
        System.out.println("Done");
    }

}

class Sum implements Callable<Integer> {
    int stop;

    Sum(int v) {
        stop = v;
    }

    public Integer call() {
        int sum = 0;
        for (int i = 1; i <= stop; i++) {
            sum += i;
        }

        return sum;
    }
}

class Hypot implements Callable<Double> {
    double side1, side2;

    Hypot(double s1, double s2) {
        side1 = s1;
        side2 = s2;
    }

    public Double call() {
        return Math.sqrt((side1 * side1) + (side2 * side2));
    }

}

class Factorial implements Callable<Integer> {
    int stop;

    Factorial(int v) {
        stop = v;
    }

    public Integer call() {
        int fact = 1;
        for (int i = 2; i <= stop; i++) {
            fact *= i;
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException in) {

        }
        return fact;
    }
}


