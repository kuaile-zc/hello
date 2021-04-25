package com.zc.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author CoreyChen Zhang
 * @Date: 2021/04/22/ 10:58
 */
public class DecodeWaysTest {

    private DecodeWays decodeWays = new DecodeWays();

    @Test
    public void case1(){
        int i1 = decodeWays.numDecodings("12");
        int i2 = decodeWays.numDecodings("226");
        int i3 = decodeWays.numDecodings("0");
        int i4 = decodeWays.numDecodings("06");
        Assert.assertEquals(i1, 2);
        Assert.assertEquals(i2, 3);
        Assert.assertEquals(i3, 0);
        Assert.assertEquals(i4, 0);
    }
}
