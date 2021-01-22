package com.zc.leetcode;

/**
 * 假设现有容量10kg的背包，
 * 另外有3个物品，分别为a1，a2，a3。物品a1重量为3kg，价值为4；物品a2重量为4kg，价值为5；物品a3重量为5kg，价值为6。
 * 将哪些物品放入背包可使得背包中的总价值最大？
 * @author CoreyChen Zhang
 * @version 2020/11/10 18:07
 * @modified
 */
public class Knapsack {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        int maxValue = knapsack.getMaxValue(new int[][]{{3, 4}, {4, 5}, {5, 6}}, 10);
        System.out.println(maxValue);
    }

    public int getMaxValue(int[][] goods, int maxCap){
        //创建数组
        int[][] ret = new int[goods.length+1][maxCap+1];
        for (int i=1; i<goods.length+1; i++){
            int weight = goods[i-1][0];
            int value = goods[i-1][1];
            for (int j=0; j<maxCap+1; j++){
                if (j >= weight){
                    ret[i][j] = Math.max(ret[i-1][j], ret[i-1][j-weight] + value);
                }

            }
        }

        return ret[goods.length][maxCap];
    }
}
