package com.prac.designpattern.designpatterns.visitor;

public class Visitor implements IVisitor {
    @Override
    public void visit(MyClass myClass) {

        System.out.println("Visitor is trying to change the value");
        myClass.setMyInt(100);
        System.out.println("Exiting from Visitor -visit \n");
    }
}
