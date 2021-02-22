package com.zc.designMode.observer;

/**
 * @author CoreyChen Zhang
 * @version 2021/2/19 17:52
 * @modified
 */
public class ConcreteObserver implements Observer{
    @Override
    public void update() {
        System.out.println("Receive the message and process it.");
    }
}
