package com.zc.lambdas.functionInterface;

/**
 * @author CoreyChen Zhang
 * @date 2022/3/12 0:25
 * @modified
 */
public class Test {

    public static void main(String[] args) {
        MyInterface myInterface = (msg) -> System.out.println(msg);
        myInterface.FunctionPrint("Hi");
    }
}
