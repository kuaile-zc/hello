package com.zc.designMode.decorator;

import java.util.Date;

/**
 * @author CoreyChen Zhang
 * @version 2020/12/25 15:08
 * @modified
 */
public class GiveCurrentTimePhone extends PhoneDecorate{
    public GiveCurrentTimePhone(Phone phone) {
        super(phone);
    }

    //自定义想要实现的功能，给出当前时间
    private void currentTime(){
        System.out.println("The time is :"+new Date());
    }

    @Override
    public void call() {
        currentTime();
        super.call();
    }
}
