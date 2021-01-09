package com.zc.leet;

/**
 * Description:
 * 990. 等式方程的可满足性
 *
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 *
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 *
 * 示例 2：
 *
 * 输入：["b==a","a==b"]
 * 输出：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 *
 * 示例 3：
 *
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 *
 * 示例 4：
 *
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 *
 * 示例 5：
 *
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 *
 *
 *
 * 提示：
 *
 *     1 <= equations.length <= 500
 *     equations[i].length == 4
 *     equations[i][0] 和 equations[i][3] 是小写字母
 *     equations[i][1] 要么是 '='，要么是 '!'
 *     equations[i][2] 是 '='
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Corey Zhang
 * @modified:
 * @version: 2021-01-07 20:46
 */
public class SatisfiabilityOfEquality {

    int[] fa = new int[26];
    int[] rank = new int[26];

    //并查集求解
    public boolean equationsPossible(String[] equations) {
        int length = equations.length;
        init();
        for (int i = 0; i < length; i++) {
            String value = equations[i];
            if (value.charAt(1) == '='){
                int x = value.charAt(0) - 'a';
                int y = value.charAt(3) - 'a';
                merge(x,y);
            }
        }

        for (int i = 0; i < length; i++) {
            String value = equations[i];
            if (value.charAt(1) == '!'){
                int x = value.charAt(0) - 'a';
                int y = value.charAt(3) - 'a';
                if (find(x) == find(y)){
                    return false;
                }
            }
        }

        return true;
    }

    //初始化
    private void init(){
        for (int i=0; i<26; i++){
            fa[i] = i;
            rank[i] = 1;
        }
    }

    //查询根节点
    private int find(int x){
        return x == fa[x] ? x : find(fa[x]);
    }

    //合并
    private void merge(int i, int j){
       int x=find(i) , y=find(j);

       if (rank[x]<=rank[y]){
           fa[x] = y;
       }else {
           fa[y] = x;
       }

       //当相同长度的时候增加一层
       if (rank[x]==rank[y] && x!=y){
           rank[y]++;
       }
    }

    public static void main(String[] args) {
        SatisfiabilityOfEquality satisfiabilityOfEquality = new SatisfiabilityOfEquality();
        String[] strings = new String[]{"a==b","b!=c","c==a"};
        satisfiabilityOfEquality.equationsPossible(strings);
    }

}
