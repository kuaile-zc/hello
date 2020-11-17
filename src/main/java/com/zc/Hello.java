package com.zc;

import com.zc.Test.ListNode;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.util.*;

/**
 *
 * @author zc
 * @create 2019-03-04 20:16
 */
public class Hello {
    public static void main(String[] args) {
//        System.out.println("Hello1");
//        List list1 = new ArrayList<Car>();
//        list1.add(new Car("BenChi",new BigDecimal(1),3.1d));
//        System.out.println(list1.getClass());
//        System.out.println(ArrayList.class);
//        System.out.println(list1.getClass().equals(ArrayList.class));
//        System.out.println(List.class);

        int a = 12535;
        Integer i = 12535;
        System.out.println(a==i);

        HashSet<Integer> set = new HashSet<>(Arrays.asList(123456));
        int b = 123456;
        Integer c = 123456;
        System.out.println(set.contains(b));
        System.out.println(set.contains(c));

        String str = "select convert(varchar, rt.SKUGroupCatalogItemID) + '_' +convert(varchar, cirt.TableKeyID) + '='  + "
                + "isnull(( select  convert(varchar, cirp.TableKeyID) + ',' from [dbo].RatePLan rp "
                + "join [dbo].CatalogItem cirp on cirp.CatalogItemId = rp.RatePlanCatalogItemID "
                + "where rp.RoomTypeCatalogItemID = rt.RoomTypeCatalogItemID for xml path('')), ',') as String "
                + "from [dbo].RoomType rt with(nolock) join [dbo].CatalogItem cirt with(nolock) "
                + "on cirt.CatalogItemId = rt.RoomTypeCatalogItemID "
                + "join [dbo].CatalogItem cisku with(nolock) on cisku.CatalogItemId = rt.SKUGroupCatalogItemID "
                + "where cisku.CatalogItemStatusTypeID = 1 and cirt.CatalogItemStatusTypeID = 1 "
                + "order by rt.SKUGroupCatalogItemID";

        System.out.println(str);

        System.out.println(1 << 4);


        System.out.println(longestMountain(new int[]{0, 1, 2, 3, 4, 5, 3, 2, 1, 0}));

//        wordBreak("catsanddog",null);


        int[] arry = new int[]{7,10,5,1,8,3,16,6};
        int[] ret = new int[8];
        merge_sort_recursive(arry, ret, 0, 7);


    }

    @Test
    public void test(){
        Logger logger = LoggerFactory.getLogger(Object.class);
        logger.info("123");
        String str = ManagementFactory.getRuntimeMXBean().getName().split("@")[1].replace('.', '_');
        System.out.println(str);
        Integer a = 129;
        Integer b = 129;
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String str1 : list) {
            if ("1".equals(str1)) {
                list.remove(str1);
            }
        }
        System.out.println(list);
        System.out.println(4 >>> 1);
        System.out.println(00001 ^ 0001);


    }



    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] ret = new int[nums1.length + nums2.length];
        double retDouble = 0;

        for (int i = 0, j = 0; i+j < nums1.length + nums2.length; ){

            if ((j >= nums2.length) || (nums1[i] < nums2[j] && i < nums1.length) ){
                ret[i+j] = nums1[i];
                i++;
            }else if (j < nums2.length){
                ret[i+j] = nums2[j];
                j++;
            }

            if (ret.length%2 == 1){
                retDouble = ret[ret.length/2];
            }else {
                retDouble =(double) (ret[ret.length/2 -1] + ret[ret.length/2])/2.0d;
            }
        }

        return retDouble;
    }


    //n 皇后问题 ,集合的回溯
    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        return getNQueensNum(n, 0, columns, diagonals1, diagonals2);

    }

    private int getNQueensNum(int n,int row,Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2){
        //如果遍历的行数等于n表示已经装满了并且多+1所以返回一种可行方案
        if (row == n){
            return 1;
        } else {
            //在这里设置可能存在的可能性
            int count = 0;
            //循环列的可能性
           for (int i = 0; i < n; i++){
               //判断该列是否已经存在
               if( columns.contains(i) ){
                   //如果存在跳过这一次列到下一列（后同）
                   continue;
               }

               int diagonalsInt1 = i + row;
               //判断从右上到左下的斜角是否存在
               if ( diagonals1.contains(diagonalsInt1)){
                   continue;
               }

               int diagonalsInt2 = i - row;
               //判断从左上到右下的斜角是否存在
               if ( diagonals2.contains(diagonalsInt2) ){
                   continue;
               }


               //如果三种判断都不存在那么表示此点位是可以放置皇后的位置
               //所以做放置皇后的操作
               columns.add(i);
               diagonals1.add(diagonalsInt1);
               diagonals2.add(diagonalsInt2);
               //现在开始已经放置了一个皇后，所以继续放但是要到下一行去放，因为不能再同一行。
               // 这里很关键如果已经放置了n个皇后那个 row必定等于n-1行 再加上1 那么现在为n行这个时候row = n
               count =count + getNQueensNum(n, row + 1, columns, diagonals1, diagonals2);
               //现在已经到回溯的关键了，递归到这一步已经要回溯（也就是将皇后旗子收起来）
               columns.remove(i);
               diagonals1.remove(diagonalsInt1);
               diagonals2.remove(diagonalsInt2);

           }

           return count;
        }
    }


    //n 皇后问题 ,位运算的回溯
    public int totalNQueens2(int n) {
        return getNQueensNumByBit(n, 0, 0, 0, 0);

    }

    private int getNQueensNumByBit(int n, int row, int columns, int diagonals1, int diagonals2) {
        //如果遍历的行数等于n表示已经装满了并且多+1所以返回一种可行方案
        if (row == n) {
            return 1;
        } else {
            //在这里设置可能存在的可能性
            int count = 0;
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            while (availablePositions != 0) {
                int position = availablePositions & (-availablePositions);
                availablePositions = availablePositions & (availablePositions - 1);
                count += getNQueensNumByBit(n, row + 1, columns | position, (diagonals1 | position) >> 1, (diagonals2 | position) << 1);
            }
            return count;

        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = new ListNode(0, head);
        ListNode second = ans;
        ListNode first = head;
        for (int i=0; i < n; i++){
            first = first.next;
        }

        while (null != first){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return ans.next;
    }

    //独一无二的路线一共有多少条   4     3     4X3的网格
    //时间复杂度mxn
    public int uniquePaths(int m, int n) {
        //构建二维数组存放结果 最大值ret[m-1][n-1]
        int[][] ret = new int[m][n];
        //设置初始值
        ret[0][0] = 0;
        //完成每行的遍历赋值 4X3 遍历3行
        for (int i = 0; i < n; i++){
            //循环列 4 列
            for (int j = 0; j < m; j++){
                //完成边界赋值
                if (i == 0 || j == 0){
                    ret[j][i] = 1;
                }else {
                    //转移方程 f(m-1,n-1) = f(m-2,n-1) + f(m-1,n-2)  => f(m,n) = f(m-1,n) + f(m,n-1)
                    ret[j][i] = ret[j-1][i] + ret[j][i-1];
                }
            }

        }

        return ret[m-1][n-1];
    }


    //青蛙是否能过河  [2,3,1,1,4].
    public boolean canJump(int[] nums) {
//        //初始化结果数组
//        boolean[] ret = new boolean[nums.length];
//
//        //初始化第一个数值
//        ret[0] = true;
//        //遍历数组
//        for (int i = 1; i < nums.length; i++){
//            //设置初始值
//            ret[i] = false;
//            //遍历i之前的数组
//            for (int j = i-1; j >= 0; j--){
//                if (ret[j] && j + nums[j] >= i){
//                    ret[i] = true;
//                    break;
//                }
//            }
//        }
//
//        return ret[nums.length - 1];

        int length = nums.length;
        int maxPath = 0;
        for (int i = 0; i < length; i++){
            if (maxPath >= i){
                maxPath = Math.max(maxPath, i + nums[i]);
            }

            if (maxPath >= length-1){
                return true;
            }

        }

        return false;

    }


    //视频拼接
    public int videoStitching(int[][] clips, int T) {
        //初始化最大位置数组
        int[] maxClip = new int[T];
        //使用贪心算法 先计算出每个位置的最大位置
        for (int[] clip : clips){
            if (clip[0] < T){
                maxClip[clip[0]] = Math.max(clip[1], maxClip[clip[0]]);
            }
        }


        //设置快始指针
        int fast = 0;
        //设置慢指针
        int slow = 0;
        //设置结果数
        int count = 0;
        for (int i = 0; i < T; i++){
            fast = Math.max(fast, maxClip[i]);

            //如果i追上fast表示已经断开
            if (i == fast){
                return -1;
            }

            //如果i追上slow表示添加一个片段
            if (i == slow){
                count++;
                slow = fast;
            }
        }


        return count;
    }



    //山峰问题
    public static int longestMountain(int[] A) {
        int length = A.length;
        if (length < 3){
            return 0;
        }
        //初始化当前位置的最大值
        int maxCount = 0;

        //初始化左右指针和长度
        int left = 0;
        int right = 0;

        //遍历数组A
        for (int i=0; i < length; i++){
            int count = 0;
            left = i;
            right = i;
            while (left - 1 >= 0 && A[left - 1] < A[left]){
                left = left - 1;
            }

            while (right + 1 < length && A[right] > A[right + 1]){
                right = right + 1;
            }

            if (right == i || left == i || right - left +1 < 3){
                count = 0;
            }else {
                count = right - left +1;
                maxCount = Math.max(maxCount, count);
            }
        }


        return maxCount;
    }


    public int[] smallerNumbersThanCurrent(int[] nums) {
        //储存结果集
        int[] ret = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            int count = 0;
            for (int j = 0; j < nums.length; j++){
                if (nums[i] > nums[j]){
                    count++;
                }
            }
            ret[i] = count;
        }

        return ret;
    }

    //单词拆分 II
    public static List<String> wordBreak(String s, List<String> wordDict) {
        //分配两个结题所需空间，第一个单词的前后坐标
        List<IndexAndStr> firstWordLastIndex = new ArrayList<>();
        List<IndexAndStr> indexAndStrList = new ArrayList<>();
        List<String> ret = new ArrayList<>();

        for (String dict : wordDict){
            //计算这个单词在句子中的前后坐标
            int first = s.indexOf(dict);
            if (-1 != first && 0 != first){
                IndexAndStr indexAndStr = new IndexAndStr();
                indexAndStr.firstIndex = first;
                indexAndStr.lastIndex = first + dict.length();
                indexAndStr.str = dict;
                indexAndStrList.add(indexAndStr);
            }else if (first == 0){
                IndexAndStr indexAndStr = new IndexAndStr();
                indexAndStr.firstIndex = first;
                indexAndStr.lastIndex = first + dict.length();
                indexAndStr.str = dict;
                firstWordLastIndex.add(indexAndStr);
            }
        }

        //遍历所有可能性

        return null;
    }

    static class IndexAndStr{
        public int firstIndex;
        public int lastIndex;
        public String str;
    }

    //归并排序
    public static int countRangeSum(int[] nums, int lower, int upper) {
        int ret = 0;
        //遍历第一次
        for (int i = 0; i < nums.length; i++){

            //拿到起始位置往下遍历
            for (int j = i; j < nums.length; j++){
                long numCount = 0;
                int index = i;
                while (index <= j){
                    numCount = numCount + nums[index];
                    index++;
                }
                //判断是否符合条件
                if (numCount >= lower && numCount<= upper){
                    ret++;
                }
            }
        }

        return ret;
    }



    static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1) {
            result[k++] = arr[start1++];
        }
        while (start2 <= end2) {
            result[k++] = arr[start2++];
        }
        for (k = start; k <= end; k++) {
            arr[k] = result[k];
        }
    }

}


