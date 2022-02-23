package com.zc.leetcode;


import java.util.ArrayList;
import java.util.List;

/**1001. 网格照明
 *
 * 在大小为 n x n 的网格 grid 上，每个单元格都有一盏灯，最初灯都处于 关闭 状态。
 *
 * 给你一个由灯的位置组成的二维数组 lamps ，其中 lamps[i] = [rowi, coli] 表示 打开 位于 grid[rowi][coli] 的灯。即便同一盏灯可能在 lamps 中多次列出，不会影响这盏灯处于 打开 状态。
 *
 * 当一盏灯处于打开状态，它将会照亮 自身所在单元格 以及同一 行 、同一 列 和两条 对角线 上的 所有其他单元格 。
 *
 * 另给你一个二维数组 queries ，其中 queries[j] = [rowj, colj] 。对于第 j 个查询，如果单元格 [rowj, colj] 是被照亮的，则查询结果为 1 ，否则为 0 。在第 j 次查询之后 [按照查询的顺序] ，关闭 位于单元格 grid[rowj][colj] 上及相邻 8 个方向上（与单元格 grid[rowi][coli] 共享角或边）的任何灯。
 *
 * 返回一个整数数组 ans 作为答案， ans[j] 应等于第 j 次查询 queries[j] 的结果，1 表示照亮，0 表示未照亮。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
 * 输出：[1,0]
 * 解释：最初所有灯都是关闭的。在执行查询之前，打开位于 [0, 0] 和 [4, 4] 的灯。第 0 次查询检查 grid[1][1] 是否被照亮（蓝色方框）。该单元格被照亮，所以 ans[0] = 1 。然后，关闭红色方框中的所有灯。
 *
 * 第 1 次查询检查 grid[1][0] 是否被照亮（蓝色方框）。该单元格没有被照亮，所以 ans[1] = 0 。然后，关闭红色矩形中的所有灯。
 *
 * 示例 2：
 *
 * 输入：n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,1]]
 * 输出：[1,1]
 *
 * 示例 3：
 *
 * 输入：n = 5, lamps = [[0,0],[0,4]], queries = [[0,4],[0,1],[1,4]]
 * 输出：[1,1,0]
 *
 *
 *
 * 提示：
 *
 *     1 <= n <= 109
 *     0 <= lamps.length <= 20000
 *     0 <= queries.length <= 20000
 *     lamps[i].length == 2
 *     0 <= rowi, coli < n
 *     queries[j].length == 2
 *     0 <= rowj, colj < n
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/grid-illumination
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2022/2/11 17:32
 * @modified
 */
public class GridIllumination {

    private int[][] DIRECTION_CONSTANT = new int[][]{{-1,0},{0,-1}, {1,0}, {0,1}, {1,1}, {1,-1}, {-1,1}, {-1,-1} };

    private int[][] grid;

    private int[][] lamps;

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        int length = queries.length;
        //Create grid
        this.grid = new int[n][n];
        this.lamps = lamps;
        //Calculate light up
        for (int[] lamp : this.lamps) {
            changeGridStatue(lamp, 1);
        }
        //Use queries and update grid
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int[] query = queries[i];
            result[i] = grid[query[0]][query[1]] <= 0 ? 0 : 1;
            getPutOutLamp(query);
        }

        return result;
    }

    private void changeGridStatue(int[] lamp, int add) {
        int n = grid.length;
        grid[lamp[0]][lamp[1]] += add;
        for (int[] direction : DIRECTION_CONSTANT) {
            int row = lamp[0] + direction[0];
            int col = lamp[1] + direction[1];
            while (row >= 0 && row < n && col >=0 && col < n) {
                grid[row][col] += add;
                row += direction[0];
                col += direction[1];
            }
        }
    }

    private void getPutOutLamp(int[] query) {
        List<int[]> temp = new ArrayList<>();
        List<int[]> removes = new ArrayList<>();
        List<String> range = new ArrayList<>();
        range.add(arrayChangeString(query));
        for (int[] direction : DIRECTION_CONSTANT) {
            range.add(arrayChangeString(new int[]{query[0] + direction[0], query[1] + direction[1]}));
        }
        for (int[] lamp : lamps) {
            if (range.contains(arrayChangeString(lamp))) {
                removes.add(lamp);
            }else {
                temp.add(lamp);
            }
        }
        int[][] tempLamps = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            tempLamps[i] = temp.get(i);
        }
        lamps = tempLamps;
        for (int[] remove : removes) {
            changeGridStatue(remove, -1);
        }
    }

    private String arrayChangeString(int[] array) {
        return array[0] + "-" + array[1];
    }

    public static void main(String[] args) {
        GridIllumination gridIllumination = new GridIllumination();
        gridIllumination.gridIllumination(5, new int[][]{{0,0}, {0,1}, {0,4}}, new int[][]{{0,0}, {0,1}, {0,2}});
    }
}
