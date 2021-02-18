package com.zc.designMode.reference.dynamic;

/**
 * @author CoreyChen Zhang
 * @version 2021/2/18 17:00
 * @modified
 */
public class Bye implements ByeInterface{
    @Override
    public void sayBye() {
        System.out.println("Bye zhangsan!");
    }
}
