package com.prac.designpattern.designpatterns.visitor;

public class VisitorPatternDemo {
    public static void main(String[] args) {

        System.out.println("*** Visitor Pattern demo *** \n");
        IVisitor visitor = new Visitor();
        MyClass myClass = new MyClass();
        myClass.accept(visitor);
    }
}
