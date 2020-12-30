package com.zc.designMode.decorator;

/**
 * 装饰者
 * @author CoreyChen Zhang
 * @version 2020/12/25 14:51
 * @modified
 */
public abstract class PhoneDecorate implements Phone{
    //以组合的方式来获取默认实现类
    private Phone phone;

    public PhoneDecorate(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void call() {
        phone.call();
    }
}
