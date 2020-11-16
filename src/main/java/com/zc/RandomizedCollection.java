package com.zc;

import com.sun.javafx.collections.MappingChange;

import java.util.*;

/**
 * Description:
 *
 * @author: Corey Zhang
 * @modified:
 * @version: 2020-10-31 13:55
 */
public class RandomizedCollection {

    Map<Integer, Integer> map;
    List<Integer> list;
    Random random = new Random(1);

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        if (null == map.get(val)){
            map.put(val,1);
            return true;
        }else {
            Integer value = map.get(val);
            value++;
            map.put(val, value);
            return false;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (null == map.get(val)){
            return false;
        }
        Integer value = map.get(val);
        value--;
        if (value == 0){
            map.remove(val);
            list.remove((Integer)val);
            return true;
        }else {
            map.put(val, value);
            list.remove((Integer)val);
            return true;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int nextInt = random.nextInt(list.size());
        return list.get(nextInt);
    }
}
