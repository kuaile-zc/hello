package com.zc.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 514. 自由之路
 *
 * 视频游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
 *
 * 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
 *
 * 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
 *
 * 旋转 ring 拼出 key 字符 key[i] 的阶段中：
 *
 *     您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
 *     如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
 *
 * 示例：
 *              G
 *          G       O
 *       N      !       D
 *          I       D
 *
 * 输入: ring = "godding", key = "gd"
 * 输出: 4
 * 解释:
 *  对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。
 *  对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
 *  当然, 我们还需要1步进行拼写。
 *  因此最终的输出是 4。
 *
 * 提示：
 *
 *     ring 和 key 的字符串长度取值范围均为 1 至 100；
 *     两个字符串中都只有小写字符，并且均可能存在重复字符；
 *     字符串 key 一定可以由字符串 ring 旋转拼出。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/freedom-trail
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/11/11 10:17
 * @modified
 */
public class FreedomTrail {
    public static void main(String[] args) {
        FreedomTrail freedomTrail = new FreedomTrail();
        freedomTrail.findRotateSteps("goddng", "gd");
    }

    //动态规划解法
    public int findRotateSteps(String ring, String key) {
        int ringLength = ring.length(), keyLength = key.length();
        //创建动态规划数组 i表示第i个key， j表示第j个ring下标的字母
        int[][] dp = new int[keyLength][ringLength];
        //创建第二维 26个字母集合
        List<Integer>[] letterList = new ArrayList[26];
        //填充数组
        for (int i=0; i<26; i++){
            letterList[i] = new ArrayList<>();
        }
        //遍历ring并且存储所有的可能下标
        for (int i=0; i<ring.length(); i++){
            char c = ring.charAt(i);
            //存储字母的下标
            letterList[c - 'a'].add(i);
        }

        //初始化初始值
        List<Integer> firstList = letterList[ key.charAt(0) - 'a'];
        for (int i=0; i<firstList.size(); i++){
            dp[0][i] = Math.min(firstList.get(i), ringLength - firstList.get(i)) + 1;
        }

        //开始循环轮休
        for (int i=1; i<keyLength; i++){
            char curIndex = key.charAt(i), priorIndex = key.charAt(i-1);
            List<Integer> curList = letterList[curIndex-'a'];
            List<Integer> priorList = letterList[priorIndex-'a'];
            for (int j=0; j<curList.size(); j++){
                int minValue = Integer.MAX_VALUE;
                for (int k=0; k<priorList.size();k++){
                    int x = priorList.get(k), y = curList.get(j);
                    int minMove = Math.min(Math.abs(x-y),ringLength - Math.abs(x-y));
                    //按下按钮+1
                    minValue = Math.min(minValue, dp[i-1][k]+minMove+1);
                }
                dp[i][j] = minValue;
            }

        }

        int ret = Integer.MAX_VALUE;
        for (int i=0; i< dp[key.length()-1].length; i++){
            if (dp[key.length()-1][i]!=0){
                ret = Math.min(ret, dp[key.length()-1][i]);
            }
        }

        return ret;
    }

    int m,n;
    int[][] memory;
    List<Integer>[] lists;

    //记忆递归解法
    public int findRotateSteps2(String ring, String key) {
        m = ring.length();
        n = key.length();
        //统计ring的字母数量
        lists = new List[26];
        //填充
        for (int i=0; i<m; i++){
            if (null == lists[ring.charAt(i)-'a']){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                lists[ring.charAt(i)-'a'] = list;
            }else {
                lists[ring.charAt(i)-'a'].add(i);
            }
        }

        memory = new int[n][m];
        //填充记忆数组
        for (int i=0; i<memory.length; i++){
            Arrays.fill(memory[i],-1);
        }
        //递归
        return dfs(0,0,key) + key.length();
     }

    //记忆递归
    private int dfs(int keyI, int ringI, String key) {
        if (keyI == n) {
            return 0;
        }
        if (memory[keyI][ringI] != -1){
            return memory[keyI][ringI];
        }

        char ch = key.charAt(keyI);
        List<Integer> list = lists[ch - 'a'];
        int minMove = Integer.MAX_VALUE;
        for (int i=0; i<list.size(); i++){
            int move = Math.min(Math.abs(ringI - list.get(i)), m - Math.abs(ringI - list.get(i)));
            move = move + dfs(keyI+1, list.get(i), key);
            minMove = Math.min(move,minMove);
        }
        memory[keyI][ringI] = minMove;
        return minMove;
    }
}
