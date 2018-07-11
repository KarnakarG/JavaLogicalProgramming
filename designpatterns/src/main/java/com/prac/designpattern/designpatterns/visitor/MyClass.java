package com.prac.designpattern.designpatterns.visitor;

public class MyClass implements IOriginalInterface {

    private int myInt = 5;


    public int getMyInt() {
        return myInt;
    }

    public void setMyInt(int myInt) {
        this.myInt = myInt;
    }

    @Override
    public void accept(IVisitor visitor) {
        System.out.println("Initial value of the integer: " + myInt);
        visitor.visit(this);
        System.out.println("Value of the integer now:  " + myInt);

    }
}
