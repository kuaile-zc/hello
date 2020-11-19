package com.zc.leet;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 *
 *     必须在原数组上操作，不能拷贝额外的数组。
 *     尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/11/19 10:24
 * @modified
 */
public class MoveZero {
    public void moveZeroes(int[] nums) {
        if (nums.length==0){
            return;
        }
        //记录非零索引
        int zeroIndex = 0;
        int notZeroIndex = 0;
        int temp = 0;

        while (notZeroIndex<nums.length){
            if (nums[zeroIndex]!=0){
                zeroIndex++;
            }else if (zeroIndex>notZeroIndex){
                //追上零指针
                notZeroIndex = zeroIndex + 1;
            }

            if(nums[notZeroIndex]==0){
                //往后找非0
                notZeroIndex++;
            }else if (nums[notZeroIndex]!=0){
                temp = nums[zeroIndex];
                nums[zeroIndex] = nums[notZeroIndex];
                nums[notZeroIndex] = temp;
            }

        }

    }
}
