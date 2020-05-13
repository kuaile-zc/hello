package com.zc;

import java.util.*;

public class Main{
    public static void main(String args[]){
        Integer[][] data = new Integer[16][16];
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String mapHand = scanner.nextLine();
            String[] strs = mapHand.split(" ");
            int a = Integer.valueOf(strs[0]);
            int b = Integer.valueOf(strs[1]);
            for (int i=0; i < a ; i++ ){
                String line = scanner.nextLine();
                String[] lineValues = line.split(" ");
                for (int j=0; j< b ; j++){
                    data[i][j] = Integer.valueOf(lineValues[j]);
                }
            }
        }

        System.out.println(getIslandNumber(data));


    }

    private static Integer getIslandNumber(Integer[][] data){
        int ret = 0;
        int m = data.length;
        if (m==0){
            return 0;
        }

        int n = data[0].length;
        for (int i = 0; i < m ; i++){
            for (int j=0 ; j < n; j++ ){
                if (data[i][j] == 1){
                    dfs(data,i,j);
                    ret++;
                }
            }
        }

        return ret;
    }

    private static void dfs(Integer[][] data,int i, int j){
        if(i<0 || j<0 || i>=data.length || j>= data[0].length)
            return;
        if (data[i][j] == 1){
            data[i][j] = 0;
            dfs(data,i-1,j);
            dfs(data,i+1,j);
            dfs(data,i,j-1);
            dfs(data,i,j+1);
        }
    }
}


