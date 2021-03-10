package com.zc.designMode.observer;

import java.util.Vector;

/**
 * 主题
 * @author CoreyChen Zhang
 * @version 2021/2/19 17:24
 * @modified
 */
public class Subject {

    //观察者组
    private Vector<Observer> oVector = new Vector<>();

    //增加一个观察者
    public void addObserver(Observer observer){
        this.oVector.add(observer);
    }

    //删除一个观察者
    public void deleteObserver(Observer observer){
        this.oVector.remove(observer);
    }

    //通知所有观察者
    public void notifyObserver(){
        for (Observer observer : oVector){
            observer.update();
        }
    }
}
