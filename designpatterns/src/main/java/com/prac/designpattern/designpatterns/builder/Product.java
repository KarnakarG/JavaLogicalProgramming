package com.prac.designpattern.designpatterns.builder;

import java.util.LinkedList;

public class Product {

    LinkedList<String> parts;

    public Product() {
        parts = new LinkedList<>();
    }

    public void add(String part) {
        parts.addLast(part);
    }

    public void show() {

        System.out.println("Products completed as of Now");

        for (int i = 0; i < parts.size(); i++) {
            System.out.println(parts.get(i));
        }
    }

}
