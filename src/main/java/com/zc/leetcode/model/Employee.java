package com.zc.leetcode.model;

import java.util.List;

/**
 * @author CoreyChen Zhang
 * @date 2021/5/1 7:54
 * @modified
 */
public class Employee {

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }

    public int id;
    public int importance;
    public List<Integer> subordinates;
}
