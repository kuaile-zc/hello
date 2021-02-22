package com.zc.designMode.observer;

/**
 *
 * @author CoreyChen Zhang
 * @version 2021/2/19 17:50
 * @modified
 */
public class ConcreteSubject extends Subject{

    //具体业务
    public void doSomething(){
        //working
        System.out.println("working...");
        super.notifyObserver();
    }
}
