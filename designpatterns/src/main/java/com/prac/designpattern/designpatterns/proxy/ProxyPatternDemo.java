package com.prac.designpattern.designpatterns.proxy;

public class ProxyPatternDemo {

    public static void main(String[] args) {

        System.out.println("*** Proxy Pattern Demo ***\n");
        Proxy proxy = new Proxy();
        proxy.doSomeWork();
    }
}
