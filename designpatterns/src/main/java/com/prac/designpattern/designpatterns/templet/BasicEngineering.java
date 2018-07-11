package com.prac.designpattern.designpatterns.templet;

public abstract class BasicEngineering {

    //  papers in the templet pattern
    public void papers() {

        // Common papers
        math();
        softSkills();

        // specialized papers
        specializedPaper();
    }

    //Non-Abstract method Math(), SoftSkills() are //already implemented by Template class
    public void math() {
        System.out.println("Mathematics");
    }

    public void softSkills() {
        System.out.println("Soft Skills");
    }

    //Abstract method SpecialPaper() must be implemented in derived classes
    public abstract void specializedPaper();
}
