package com.zc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 179. 最大数
 * <p>
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出："1"
 * <p>
 * 示例 4：
 * <p>
 * 输入：nums = [10]
 * 输出："10"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CoreyChen Zhang
 * @version 2021/4/12 10:16
 * @modified
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {

        List<String> collect = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.toList());
        Collections.sort(collect, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String copy1 = o1 + o2, copy2 = o2 + o1;
                for (int i = 0; i < o1.length() + o2.length(); i++) {
                    if (copy2.charAt(i) > copy1.charAt(i)) {
                        return 1;
                    } else if (copy2.charAt(i) < copy1.charAt(i)) {
                        return -1;
                    }
                }
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String str : collect) {
            sb.append(str);
        }
        while (sb.length() > 0 && sb.charAt(0) - '0' == 0) {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        largestNumber.largestNumber(new int[]{1113, 111311});
    }
}
