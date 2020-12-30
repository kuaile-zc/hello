package com.zc.leet;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**85. 最大矩形
 *
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 *   1   0   1   0   0
 *   1   0   1   1   1
 *   1   1   1   1   1
 *   1   0   0   1   0
 *
 * 示例 1：
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 *
 * 示例 2：
 *
 * 输入：matrix = []
 * 输出：0
 *
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 *
 * 示例 4：
 *
 * 输入：matrix = [["1"]]
 * 输出：1
 *
 * 示例 5：
 *
 * 输入：matrix = [["0","0"]]
 * 输出：0
 *
 *
 *
 * 提示：
 *
 *     rows == matrix.length
 *     cols == matrix[0].length
 *     0 <= row, cols <= 200
 *     matrix[i][j] 为 '0' 或 '1'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/12/26 17:25
 * @modified
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int length = matrix.length;
        if (length==0){
            return 0;
        }
        int ret = 0;
        int cols = matrix[0].length;
        int[] arrays = new int[cols];
        for (int i=0; i<length; i++){
            for (int j=0; j<cols; j++){
                arrays[j] = matrix[i][j]=='0' ? 0 : arrays[j]+1;
            }
            ret = Math.max(ret, largestRectangleArea(arrays));
        }
        return ret;
    }

    //使用栈
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 1) {
            return heights[0];
        }
        int[] newHeights = new int[len+2];
        for (int i=0; i<len; i++){
            newHeights[i+1] = heights[i];
        }
        heights = newHeights;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        stack.offer(0);
        for (int i = 1; i < newHeights.length; i++) {
            int height = heights[i];
            while (height < heights[stack.peekLast()]){
                int curHeight = heights[stack.pollLast()];
                int wide =i - stack.peekLast() -1;
                res = Math.max(res, wide*curHeight);
            }
            stack.offer(i);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        maximalRectangle.maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
    }

}
