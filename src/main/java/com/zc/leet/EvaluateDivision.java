package com.zc.leet;

import java.util.*;

/**
 * @author CoreyChen Zhang
 * @version 2021/1/11 17:04
 * @modified
 */
public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int length = queries.size();

        int id = 0;
        Map<String, Integer> map = new HashMap<>();
        UnionFind unionFind = new UnionFind(equations.size()*2);
        double[] ret = new double[length];
        for (int i=0; i<equations.size(); i++){
            List<String> equation = equations.get(i);
            String s1 = equation.get(0);
            String s2 = equation.get(1);
            if (!map.containsKey(s1)){
                map.put(s1, id++);
            }

            if (!map.containsKey(s2)){
                map.put(s2, id++);
            }
            unionFind.merge(map.get(s1), map.get(s2), values[i]);

        }

        for (int i = 0; i < length; i++) {
            List<String> equation = queries.get(i);
            String s1 = equation.get(0);
            String s2 = equation.get(1);
            if (map.containsKey(s1) && map.containsKey(s2)){
                ret[i] = unionFind.isConnected(map.get(s1), map.get(s2));
            }else {
                ret[i] = -1;
            }

        }

        return ret;
    }

    /**
     * 带权并查集实现 路径压缩
     */
    private class UnionFind{

        private int[] parent;

        private double[] weight;

        //初始化
        public UnionFind(int n) {
            this.parent =new int[n];
            this.weight =new double[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        //路径压缩
        private int find(int i){
            if (i != parent[i]){
                int origin = parent[i];
                parent[i] = find(parent[i]);
                weight[i] *= weight[origin];
            }
            return parent[i];
        }



        private void merge(int x, int y, double value){
            int rootX=find(x), rootY=find(y);

            if (rootX==rootY){
                return;
            }

            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];
        }

        public double isConnected(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY){
                return weight[x] / weight[y];
            }else {
                return -1.0d;
            }
        }

    }

    public static void main(String[] args) {
        EvaluateDivision evaluateDivision = new EvaluateDivision();
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a","b"));
        equations.add(Arrays.asList("b","c"));
        equations.add(Arrays.asList("bc","cd"));
        double[] values = new double[]{1.5, 2.5,5.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a","c"));
        queries.add(Arrays.asList("c","b"));
        queries.add(Arrays.asList("bc","cd"));
        queries.add(Arrays.asList("cd","bc"));
        queries.add(Arrays.asList("x","x"));
        evaluateDivision.calcEquation(equations, values, queries);
    }
}
