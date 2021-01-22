package com.zc.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/12/19 11:48
 * @modified
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int left = 0;
        int right = length-1;
        while (left<right){
            rotateTarget(matrix, left, right);
            left++;
            right--;
        }
    }

    private void rotateTarget(int[][] matrix, int left, int right){

        int moveStep = right - left;
        Queue<Integer> queue = new LinkedList<>();
        int stopX = left;
        int stopY = left + (moveStep-1);
        //填充初始值
        for (int i=0; i<moveStep; i++){
            queue.offer(matrix[stopX][stopX+i]);
        }
        int x = left;
        int y = right;
        int step = (moveStep+1)*(moveStep+1) - (moveStep-1)*(moveStep-1);
        if (moveStep == 1){
            step = (moveStep+1)*(moveStep+1);
        }

        for (int i=0; i<step; i++){
            //第一步 右边往下走
            if (y==right && x<right){
                queue.offer(matrix[x][y]);
                matrix[x][y] = queue.poll();
                x++;
                continue;
            }

            //第二步 下边往左走
            if (x==right && y!=left){
                queue.offer(matrix[x][y]);
                matrix[x][y] = queue.poll();
                y--;
                continue;
            }

            //第三步 左边往上走
            if(y==left && x>left){
                queue.offer(matrix[x][y]);
                matrix[x][y] = queue.poll();
                x--;
                continue;
            }

            //第四步 上边往右走
            if (x==left && y<right){
                queue.offer(matrix[x][y]);
                matrix[x][y] = queue.poll();
                y++;
                continue;
            }

        }
    }


    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotateImage.rotate(matrix);
    }
}
