package com.zc.leetcode;

import org.junit.Test;
import org.testng.Assert;


/**
 * @Author CoreyChen Zhang
 * @Date: 2021/04/17/ 9:40
 */
public class ContainsDuplicate3Test {

    private ContainsDuplicate3 containsDuplicate3 = new ContainsDuplicate3();

    @Test
    public void case1(){
        boolean b = containsDuplicate3.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
        boolean c = containsDuplicate3.containsNearbyAlmostDuplicate(new int[]{-2147483648,2147483647}, 1, 1);
        Assert.assertEquals(b,true);
        Assert.assertEquals(c,false);
    }

}