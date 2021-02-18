package com.zc.designMode.reference.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author CoreyChen Zhang
 * @version 2021/2/18 16:56
 * @modified
 */
public class ProxyHandler implements InvocationHandler {

    private Object object;

    public ProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke "+ method.getName());
        method.invoke(object, args);
        System.out.println("After invoke "+ method.getName());
        return null;
    }
}
