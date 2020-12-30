package com.zc.designMode.decorator;

/**
 * @author CoreyChen Zhang
 * @version 2020/12/25 14:49
 * @modified
 */
public class Iphone implements Phone{

    @Override
    public void call() {
        System.out.println("Call xxx-xxx-xxx ing.....");
    }
}
