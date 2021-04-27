package leetcode;

import com.zc.leetcode.LargestDivisibleSubset;
import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CoreyChen Zhang
 * @date 2021/4/23 9:47
 * @modified
 */
public class LargestDivisibleSubsetTest {

    private LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();

    @Test
    public void case1(){
        List<Integer> list1 = largestDivisibleSubset.largestDivisibleSubset(new int[]{4,8,10,240});
        List<Integer> list2 = largestDivisibleSubset.largestDivisibleSubset(new int[]{1,2,4,8});
        List<Integer> expect = new ArrayList<>();
        expect.addAll(Arrays.asList(1,2,4,8));
        Assert.assertEquals(list2, expect);

    }
}
