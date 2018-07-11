package com.prac.designpattern.designpatterns.strategy;

public class Context {

    IChoice ch;

    // Set a Strategy or algorithm in the Context
    public void setChoice(IChoice ch) {
        this.ch = ch;
    }

    public void showShoice(String str1, String str2) {
        {
            ch.myChoice(str1, str2);
        }

    }
}
