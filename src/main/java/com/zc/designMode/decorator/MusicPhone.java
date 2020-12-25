package com.zc.designMode.decorator;

/**
 * @author CoreyChen Zhang
 * @version 2020/12/25 14:56
 * @modified
 */
public class MusicPhone extends PhoneDecorate{

    public MusicPhone(Phone phone) {
        super(phone);
    }

    //定义扩展音乐功能
    private void listenMusic(){
        System.out.println("你飘阿飘啊,骄傲的放纵...........");
    }

    @Override
    public void call() {
        listenMusic();
        super.call();
    }
}
