package com.zc;

import com.zc.lambdas.demo.model.IntObject;
import com.zc.sample.jackson.TreeNode;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
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
        System.out.println(a == i);

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


        String[] A = new String[]{"bella", "label", "roller"};
        System.out.println(commonChars(A));


        int[] nums = new int[]{-1, -2, -3, -4, -5};
        Arrays.stream(twoSum(nums, -8)).forEach(System.out::print);

        System.out.println("");
        String str2 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str2));


        String getPTZ = "getptzinfo";
        byte[] bytes = getPTZ.getBytes();
        short length = (short) bytes.length;
        System.out.printf("  " + bytes + "  " + length);


        System.out.println(backspaceCompare("ab#c", "ab#c"));


        System.out.println(coinChange(new int[]{1, 2, 5}, 11));

        maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}});

        canCross(new int[]{0, 1, 3, 4, 5, 7, 9, 10, 12});

        partitionLabels("ababcbacadefegdehijhklij");


        ListNode inpust = new ListNode(1);
        inpust.next = new ListNode(2, new ListNode(1));

        isPalindrome(inpust);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(10, 1);

        intersection(new int[]{1,2,2,1}, new int[]{2,2});

    }

    @Test
    public void test() {
//        Logger logger = LoggerFactory.getLogger(Object.class);
//        logger.info("123");
//        String str = ManagementFactory.getRuntimeMXBean().getName().split("@")[1].replace('.', '_');
//        System.out.println(str);
//        Integer a = 129;
//        Integer b = 129;
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

    public static List<String> commonChars(String[] A) {
        int[] retArray = new int[26];
        Arrays.fill(retArray, Integer.MAX_VALUE);
        List<String> ret = new ArrayList<>();
        for (String a : A) {
            int[] tempArray = new int[26];
            for (int i = 0; i < a.length(); i++) {
                char ch = a.charAt(i);
                int index = ch - 'a';
                tempArray[index]++;
            }

            for (int i = 0; i < 26; i++) {
                retArray[i] = Integer.min(retArray[i], tempArray[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            int num = retArray[i];
            while (num > 0) {
                char ch = (char) ('a' + i);
                ret.add(String.valueOf(ch));
                num--;
            }

        }

        return ret;
    }


    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (null != map.get(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }


        return new int[0];
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode();
        if (null == l1 && null == l2) {
            return null;
        }

        if (null == l1) {
            l1 = new ListNode(0);
        }
        if (null == l2) {
            l2 = new ListNode(0);
        }

        ListNode temp = new ListNode();
        temp.val = l1.val + l2.val;
        if (temp.val >= 10) {
            temp.val = temp.val - 10;
            if (null != l1.next) {
                l1.next.val++;
            } else {
                l1.next = new ListNode(1);
            }
        }
        temp.next = addTwoNumbers(l1.next, l2.next);
        return temp;
    }


    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxNum = 0;
        HashSet<Character> set = new HashSet<>(s.length());
        int leftIndex = -1;
        int rightIndex = 0;
        for (; rightIndex < s.length(); ) {
            if (set.contains(s.charAt(rightIndex))) {
                leftIndex++;
                set.remove(s.charAt(leftIndex));
                continue;
            }
            maxNum = Integer.max(maxNum, rightIndex - leftIndex);
            set.add(s.charAt(rightIndex));
            rightIndex++;

        }

        return maxNum;
    }


    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public Node connect(Node root) {
        if (null == root) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node hand = queue.poll();
        for (int i = 0; i < queue.size(); i++) {
            Node node = queue.poll();
            hand.next = node;
        }

        return null;
    }


    public static boolean backspaceCompare(String S, String T) {
        StringBuilder s = new StringBuilder(S);
        return backspace(S).equals(backspace(T));
    }

    //计算出#退格字符串
    private static String backspace(String str) {
        StringBuilder ret = new StringBuilder("");
        int back = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            String c = String.valueOf(str.charAt(i));
            if ("#".equals(c)) {
                back++;
            } else if (back != 0) {
                back--;
            } else {
                ret.append(c);
            }

        }

        return ret.toString();
    }

    // coins: 1,2,5     amount:11
    public static int coinChange(int[] coins, int amount) {
        //初始化数组存放结果
        int[] ret = new int[amount + 1];
        //初始化最初值
        ret[0] = 0;

        //开始循环递增一直到amount
        for (int i = 1; i <= amount; i++) {
            //初始化每一个值
            ret[i] = Integer.MAX_VALUE;

            //遍历硬币的种类
            for (int j = 0; j < coins.length; j++) {
                //设置判断条件
                if (i - coins[j] >= 0 && ret[i - coins[j]] != Integer.MAX_VALUE) {
                    //计算公式 f[11] = min{ f[11-5]+1 , f[11-2]+1, f[11-1]+1}
                    ret[i] = Math.min(ret[i - coins[j]] + 1, ret[i]);
                }

            }
        }

        //设置如果是最大值则为-1.
        if (ret[amount] == Integer.MAX_VALUE) {
            ret[amount] = -1;
        }

        return ret[amount];
    }

    //1->2->3->4     1->4->2->3
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode node = head.next;
        Deque<ListNode> listNodes = new LinkedList<>();
        //使用数组存储head后面的链表，然后依次取出
        while (null != node) {
            listNodes.add(node);
            node = node.next;
        }

        //依次存入head后面
        while (!listNodes.isEmpty()) {
            head.next = listNodes.pollLast();
            head = head.next;

            if (!listNodes.isEmpty()) {
                head.next = listNodes.pollFirst();
                head = head.next;
            }
        }

        head.next = null;
    }

    public ListNode middleNode(ListNode head) {
        if (null == head.next) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (null != fast && null != fast.next) {
            //快指针每次走两步
            fast = fast.next;
            fast = fast.next;
            //慢指针每次都一步
            slow = slow.next;
        }

        return slow;
    }

    // 1->2->3->null    null<-1<-2<-3.
    public ListNode reverseList(ListNode head) {
        if (null == head && null == head.next) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = null;
        ListNode temp;
        while (null != fast) {
            //临时指针指向慢指针
            temp = slow;
            //慢指针指向快指针
            slow = fast;
            //快指针前移一步
            fast = fast.next;
            //变换next箭头方向
            slow.next = temp;

        }

        return slow;
    }


    /**
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     *
     * @param matrix
     * @return 求正方形最大面积
     */
    public static int maximalSquare(char[][] matrix) {
        //矩阵的行数
        int xLength = matrix.length;
        if (xLength == 0) {
            return 0;
        }
        //矩阵的列数
        int yLength = matrix[0].length;
        //初始化结果集
        int[][] ret = new int[xLength][yLength];
        int maxValue = 0;

        //初始化第一行和第一列
        for (int i = 0; i < yLength; i++) {
            if (matrix[0][i] == '1') {
                ret[0][i] = 1;
                maxValue = Math.max(maxValue, ret[0][i]);
            }
        }

        for (int i = 0; i < xLength; i++) {
            if (matrix[i][0] == '1') {
                ret[i][0] = 1;
                maxValue = Math.max(maxValue, ret[i][0]);
            }

        }

        //遍历每行从第二行开始（第二行序列号1）
        for (int i = 1; i < xLength; i++) {
            for (int j = 1; j < yLength; j++) {
                if (matrix[i][j] == '1') {
                    //状态转移方程式 f(i,j) = min{ f(i-1, j), f(i, j-1), f(i-1, j-1)}
                    ret[i][j] = Math.min(Math.min(ret[i - 1][j], ret[i][j - 1]), ret[i - 1][j - 1]) + 1;
                    maxValue = Math.max(maxValue, ret[i][j]);
                }
            }
        }

        return maxValue * maxValue;
    }

    //升级版青蛙跳跃
    public static boolean canCross(int[] stones) {
        //创建储存map
        Map<Integer, Set<Integer>> stepMap = new HashMap<>(stones.length);
        //初始化map
        for (int i = 0; i < stones.length; i++) {
            stepMap.put(i, new HashSet<>());
        }
        //初始化第一个值
        stepMap.get(0).add(0);

        for (int i = 0; i < stones.length; i++) {
            for (Integer k : stepMap.get(i)) {
                for (int step = i + 1; step <= stones.length - 1 && stones[step] - stones[i] <= k + 1; step++) {
                    if (stones[step] - stones[i] >= k - 1) {
                        stepMap.get(step).add(stones[step] - stones[i]);

                    }
                }
            }

        }

        return stepMap.get(stones.length - 1).size() > 0;
    }


    //划分字母区间
    public static List<Integer> partitionLabels(String S) {
        //初始化结果集
        List<Integer> ret = new ArrayList<>();
        //初始化快慢指针
        int fast = 0;
        int slow = 0;
        //增加一个判断数组
        boolean[] booleans = new boolean[26];

        while (fast < S.length()) {
            //初始化endIndex
            int endIndex = slow;
            for (int j = slow; j <= endIndex; j++) {
                Character ch = S.charAt(j);
                if (!booleans[ch - 'a'] && S.lastIndexOf(ch) > endIndex) {
                    endIndex = S.lastIndexOf(S.charAt(j));
                    booleans[ch - 'a'] = true;
                }
            }

            fast = endIndex + 1;
            ret.add(fast - slow);
            slow = fast;
        }

        return ret;
    }


    //判断是否是回文链表
    public static boolean isPalindrome(ListNode head) {
        if (null == head) {
            return false;
        }
        //创建数组
        List<Integer> ret = new ArrayList<>();

        while (null != head) {
            ret.add(head.val);
            head = head.next;
        }

        for (int i = 0, j = ret.size() - 1; i <= j; i++, j--) {
            if (!ret.get(i).equals(ret.get(j))) {
                return false;
            }
        }

        return true;
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int length = nums.length;
        //创建结果集
        int[] ret = new int[length];
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int j = 0; j < length; j++) {

            }
        }

        return nums;
    }


    //1207. 独一无二的出现次数
    public boolean uniqueOccurrences(int[] arr) {
        //初始化存储次数的Map
        Map<Integer, Integer> saveNumberMap = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (null == saveNumberMap.get(arr[i])) {
                saveNumberMap.put(arr[i], 1);
            } else {
                saveNumberMap.put(arr[i], saveNumberMap.get(arr[i]) + 1);
            }
        }

        //创建结果集
        Map<Integer, Integer> ret = new HashMap<>(saveNumberMap.size());
        for (Map.Entry<Integer, Integer> set : saveNumberMap.entrySet()) {
            if (null == ret.get(set.getValue())) {
                ret.put(set.getValue(), 1);
            } else {
                return false;
            }
        }

        return true;
    }

    //求根到叶子节点数字之和
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    //深度优先搜索
    private int dfs(TreeNode root, int preSum) {
        if (null == root) {
            return 0;
        }
        int sum = preSum * 10 + root.val;

        if (null != root.right || null != root.left) {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }

        return sum;
    }

    //岛屿的周长
    public int islandPerimeter(int[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //先加
                if (grid[i][j] == 1) {
                    count = count + 4;
                    if (i > 0) {
                        if (grid[i - 1][j] == 1) {
                            count = count - 2;
                        }
                    }

                    if (j > 0) {
                        if (grid[i][j - 1] == 1) {
                            count = count - 2;
                        }
                    }
                }

            }
        }

        return count;
    }


    //349. 两个数组的交集
    public static int[] intersection(int[] nums1, int[] nums2) {
        //初始化Set
        Set<Integer> set1 = new HashSet<>(nums1.length);
        List<Integer> list = new ArrayList<>(Math.min(nums1.length, nums2.length));
        //遍历nums1
        for (int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }
        //遍历nums2
        for (int i = 0; i < nums2.length; i++){
            if (set1.contains(nums2[i])){
                list.add(nums2[i]);
                set1.remove(nums2[i]);
            }
        }

        int[] ret = new int[list.size()];
        for (int i=0 ; i < list.size(); i++){
            ret[i] = list.get(i);
        }
        return ret;
    }

    //349. 两个数组的交集
    public static int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> integerSet = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(integerSet::contains).toArray();
    }

    //941. 有效的山脉数组
    public boolean validMountainArray(int[] A) {
        if (A.length < 3){
            return false;
        }
        //设置下标
        int index = 0;
        int top = Integer.MAX_VALUE;

        for (int i = 1; i < A.length; i++){
            if (Integer.MAX_VALUE == top){
                //上升
                if (A[index] < A[i]){
                    index = i;
                }else if (A[index] == A[i]){
                    return false;
                }else {
                    top = index;
                }
            }else {
                //下降
                if (A[index] > A[i]){
                    index = i;
                }else if (A[index] <= A[i]){
                    return false;
                }
            }
        }

        if (top != Integer.MAX_VALUE && top !=0){
            return true;
        }


        return false;
    }


    //941. 有效的山脉数组
    public boolean validMountainArray2(int[] A) {
        if (A.length < 3) {
            return false;
        }
        //设置下标
        int leftTop = 0;
        int rightTop = A.length - 1;

        //从左到右找山峰
        while (leftTop + 1 < A.length && A[leftTop + 1] > A[leftTop]) {
            leftTop++;
        }

        //从右到左找山峰
        while (rightTop -1 >= 0 && A[rightTop -1] > A[rightTop] ) {
            rightTop--;
        }

        if (leftTop == A.length-1 || rightTop == 0){
            return false;
        }

        return leftTop == rightTop;
    }


}


