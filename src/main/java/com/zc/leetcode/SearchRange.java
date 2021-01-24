package com.zc.leetcode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 *     你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 *
 *
 * 提示：
 *
 *     0 <= nums.length <= 105
 *     -109 <= nums[i] <= 109
 *     nums 是一个非递减数组
 *     -109 <= target <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/12/1 9:54
 * @modified
 */
public class SearchRange {

    //二分法
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if (length==0){
            return new int[]{-1,-1};
        }
        int retIndex = findTarget(nums, 0, length-1, target);
        if (retIndex==-1){
            return new int[]{-1,-1};
        }

        int rightRetIndex = retIndex;
        while (rightRetIndex+1 <= length-1 && nums[rightRetIndex+1] == target){
            rightRetIndex++;
        }

        while (retIndex-1 >= 0 && nums[retIndex-1] == target){
            retIndex--;
        }

        return new int[]{retIndex, rightRetIndex};

    }

    private int findTarget(int[] nums, int left, int right, int target){
        if (left == right){
            if (nums[left]==target){
                return left;
            }
            return -1;
        }

        int mid = (left+right)/2;
        if (nums[mid]==target){
            return mid;
        }

        if (nums[mid] < target){
            return findTarget(nums, mid+1, right, target);
        }else {
            return findTarget(nums, left, mid, target);
        }
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        searchRange.searchRange(new int[]{2,2},2);
    }
}
