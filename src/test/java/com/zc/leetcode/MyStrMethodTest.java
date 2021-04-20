package com.zc.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author CoreyChen Zhang
 * @Date: 2021/04/20/ 9:48
 */
public class MyStrMethodTest {

    private MyStrMethod myStrMethod = new MyStrMethod();

    @Test
    public void case1(){
        int i1 = myStrMethod.strStr("hello", "ll");
        int i2 = myStrMethod.strStr("aaaaa", "bba");
        int i3 = myStrMethod.strStr("", "");
        Assert.assertEquals(i1,2);
        Assert.assertEquals(i2,-1);
        Assert.assertEquals(i3,0);
    }
}
