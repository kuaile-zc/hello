package com.zc.leetcode;

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
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
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


    public void moveZeroes2(int[] nums) {
        if(nums==null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for(int i=0;i<nums.length;++i) {
            if(nums[i]!=0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for(int i=j;i<nums.length;++i) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZero moveZero = new MoveZero();
        moveZero.moveZeroes2(new int[]{0,1,0,3,12});
    }
}
