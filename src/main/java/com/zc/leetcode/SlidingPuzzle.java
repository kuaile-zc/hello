package com.zc.leetcode;

import java.util.*;

/**
 * 773. 滑动谜题
 * <p>
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 * <p>
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * <p>
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * <p>
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 * <p>
 * 示例：
 * <p>
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * <p>
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 * <p>
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 * <p>
 * 输入：board = [[3,2,4],[1,5,0]]
 * 输出：14
 * <p>
 * 提示：
 * <p>
 * board 是一个如上所述的 2 x 3 的数组.
 * board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author CoreyChen Zhang
 * @Date: 2021/06/26/ 17:45
 */
public class SlidingPuzzle {

    private int[][] target = new int[][]{{1, 2, 3}, {4, 5, 0}};

    private int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int slidingPuzzle(int[][] board) {
        Queue<int[][]> queue1 = new LinkedList<>();
        Queue<int[][]> queue2 = new LinkedList<>();
        List<int[][]> visited = new ArrayList<>();
        visited.add(board);
        int step = 0;
        queue1.add(board);

        while (!queue1.isEmpty()) {
            int[][] poll = queue1.poll();
            if (isequal(poll, target)) {
                return step;
            }
            List<int[][]> next = getNext(poll);
            for (int[][] path : next) {
                if (!contains(visited, path)) {
                    visited.add(path);
                    queue2.add(path);
                }
            }
            if (queue1.isEmpty()) {
                queue1 = queue2;
                queue2 = new LinkedList<>();
                step++;
            }
        }

        return -1;
    }

    private List<int[][]> getNext(int[][] origin) {
        List<int[][]> result = new ArrayList<>();
        int i = 0, j = 0;
        for (int k = 0; k < 2; k++) {
            for (int l = 0; l < 3; l++) {
                if (origin[k][l] == 0) {
                    i = k;
                    j = l;
                }
            }
        }

        for (int[] direction : DIRECTIONS) {
            int changeI = i + direction[0];
            int changeJ = j + direction[1];
            if (changeI >= 0 && changeI <= 1 && changeJ >= 0 && changeJ <= 2) {
                int[][] add = copy(origin);
                add[i][j] = add[changeI][changeJ];
                add[changeI][changeJ] = 0;
                result.add(add);
            }
        }

        return result;
    }

    private int[][] copy(int[][] origin) {
        int[][] result = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = origin[i][j];
            }
        }
        return result;
    }

    private boolean isequal(int[][] origin, int[][] compare){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (compare[i][j] != origin[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean contains(List<int[][]> visited, int[][] origin){
        for (int i = 0; i < visited.size() ; i++) {
            if (isequal(visited.get(i), origin)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SlidingPuzzle slidingPuzzle = new SlidingPuzzle();
        slidingPuzzle.slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}});
    }


//    class Board{
//
//        public Board(int one_one, int one_two, int one_three, int two_one, int two_two, int two_three) {
//            this.one_one = one_one;
//            this.one_two = one_two;
//            this.one_three = one_three;
//            this.two_one = two_one;
//            this.two_two = two_two;
//            this.two_three = two_three;
//        }
//
//        private int one_one;
//        private int one_two;
//        private int one_three;
//        private int two_one;
//        private int two_two;
//        private int two_three;
//
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Board board = (Board) o;
//            return one_one == board.one_one && one_two == board.one_two && one_three == board.one_three && two_one == board.two_one && two_two == board.two_two && two_three == board.two_three;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(one_one, one_two, one_three, two_one, two_two, two_three);
//        }
//    }
}
