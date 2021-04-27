package leetcode;

import com.zc.leetcode.ShipWithinDays;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author CoreyChen Zhang
 * @date 2021/4/26 9:25
 * @modified
 */
public class ShipWithinDaysTest {

    private ShipWithinDays shipWithinDays = new ShipWithinDays();

    @Test
    public void case1(){
        int load = shipWithinDays.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
        Assert.assertEquals(load, 15);
    }
}
