package com.zc.designMode.reference.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理演示代码
 *
 * @author CoreyChen Zhang
 * @version 2021/2/18 16:54
 * @modified
 */
public class ProxyMain {

    public static void main(String[] args) {
        ByeInterface bye = new Bye();

        InvocationHandler handler = new ProxyHandler(bye);

        ByeInterface byeInterface = (ByeInterface)Proxy.newProxyInstance(bye.getClass().getClassLoader(), bye.getClass().getInterfaces(), handler);
        byeInterface.sayBye();
    }
}
