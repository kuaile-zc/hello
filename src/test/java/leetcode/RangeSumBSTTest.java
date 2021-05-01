package leetcode;

import com.zc.leetcode.RangeSumBST;
import com.zc.leetcode.TreeNode;
import org.junit.Test;
import org.testng.Assert;

/**
 * @author CoreyChen Zhang
 * @date 2021/4/27 16:37
 * @modified
 */
public class RangeSumBSTTest {

    private RangeSumBST rangeSumBST = new RangeSumBST();

    private TreeNode buildTestCase1(){
        TreeNode root = new TreeNode(10);
        TreeNode rootLeft = new TreeNode(5);
        TreeNode rootRight = new TreeNode(15);
        rootLeft.left = new TreeNode(3);
        rootLeft.right = new TreeNode(7);
        rootRight.right = new TreeNode(18);
        root.left = rootLeft;
        root.right = rootRight;
        return root;
    }

    @Test
    public void case1(){
        int sum = rangeSumBST.rangeSumBST(buildTestCase1(), 7, 15);
        Assert.assertEquals(sum, 32);
    }
}
