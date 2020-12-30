package com.zc.designMode.decorator;

/**
 * 装饰者模式案例
 * @author CoreyChen Zhang
 * @version 2020/12/25 15:04
 * @modified
 */
public class Main {
    public static void main(String[] args) {
        //创建出最原始的实现类
        Phone phone = new Iphone();

        //装饰打电话之前可以听音乐
        phone = new MusicPhone(phone);

        phone = new GiveCurrentTimePhone(phone);

        phone.call();
    }
}
