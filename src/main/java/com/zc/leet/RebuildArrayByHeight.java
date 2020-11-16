package com.zc.leet;

import java.util.*;

/**
 * @author CoreyChen Zhang
 * @version 2020/11/16 14:19
 * @modified
 */
public class RebuildArrayByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1,o2)-> o1[0]==o2[0]? o1[1]-o2[1] : o2[0]-o1[0]);
        List<int[]> list = new LinkedList<>();
        for (int[] i: people){
            list.add(i[1],i);
        }
        return list.toArray(people);
    }


    public static void main(String[] args) {
        RebuildArrayByHeight rebuildArrayByHeight = new RebuildArrayByHeight();
        int[][] input =new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        rebuildArrayByHeight.reconstructQueue(input);
    }

}
