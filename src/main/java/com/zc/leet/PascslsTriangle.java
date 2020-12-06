package com.zc.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 * 118. Pascal's Triangle
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: Corey Zhang
 * @modified:
 * @version: 2020-12-06 11:33
 */
public class PascslsTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0){
            return new ArrayList<>();
        }

        List<List<Integer>> ret = new ArrayList<>(numRows);
        for (int i=1; i<=numRows; i++){
            Integer[] row = new Integer[i];
            Arrays.fill(row,1);
            if (i>=3){
                for (int j=1; j<i-1; j++){
                    List<Integer> priList = ret.get(i - 2);
                    row[j] = priList.get(j-1) + priList.get(j);
                }
            }
            ret.add(Arrays.asList(row));
        }
        

        return ret;
    }

    public static void main(String[] args) {
        PascslsTriangle pascslsTriangle = new PascslsTriangle();
        pascslsTriangle.generate(3);
    }
}
