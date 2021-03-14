package com.zc.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 706. 设计哈希映射
 *
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 *
 * 实现 MyHashMap 类：
 *
 *     MyHashMap() 用空映射初始化对象
 *     void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 *     int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 *     void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * 输出：
 * [null, null, null, 1, -1, null, 1, null, -1]
 *
 * 解释：
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
 * myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
 * myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
 * myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
 * myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 *
 *
 *
 * 提示：
 *
 *     0 <= key, value <= 106
 *     最多调用 104 次 put、get 和 remove 方法
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashmap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/3/14 20:25
 * @modified
 */
public class DesignHashMap {

    static class MyHashMap {

        private int[] data;

        /** Initialize your data structure here. */
        public MyHashMap() {
            data = new int[8];
            Arrays.fill(data,-1);
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            reset(key);
            data[key] = value;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            if (key >= data.length){
                return -1;
            }
            return data[key];
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            if (key < data.length){
                data[key] = -1;
            }

        }

        private void reset(int key){
            if (key >= data.length){
                int[] temp = new int[key+1];
                Arrays.fill(temp,-1);
                for (int i = 0; i < data.length; i++) {
                    temp[i] = data[i];
                }
                data = temp;
            }
        }

    }


    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(7,3);
        map.get(7);
    }
}
