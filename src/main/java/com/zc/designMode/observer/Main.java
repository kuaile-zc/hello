package com.zc.designMode.observer;

/**
 * 观察者模式实例代码
 * @author CoreyChen Zhang
 * @version 2021/2/19 17:24
 * @modified
 */
public class Main {

    public static void main(String[] args) {
        //创建一个主题
        ConcreteSubject subject = new ConcreteSubject();
        //定义一个观察者
        Observer observer = new ConcreteObserver();
        //观察
        subject.addObserver(observer);
        //开始活动
        subject.doSomething();

    }
}
