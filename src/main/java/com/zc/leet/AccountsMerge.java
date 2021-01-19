package com.zc.leet;

import java.util.*;

/**
 * 721. 账户合并
 *
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 *
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 *
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 输出：
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 *
 *
 *
 * 提示：
 *
 *     accounts的长度将在[1，1000]的范围内。
 *     accounts[i]的长度将在[1，10]的范围内。
 *     accounts[i][j]的长度将在[1，30]的范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/accounts-merge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CoreyChen Zhang
 * @version 2021/1/18 11:09
 * @modified
 */
public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ret = new ArrayList<>();
        Set<String> nameSet = new HashSet<>();
        Map<String, Integer> accountMap = new HashMap<>();
        int index = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            if (nameSet.contains(name)){
                Integer retIndex = accountMap.get(name);
                List<String> accountOrigin = ret.get(retIndex);
                boolean isSame = false;
                for (String str : account){
                    if (name.equals(account)){
                        continue;
                    }
                    if (accountOrigin.contains(str)){
                        isSame = true;
                        break;
                    }
                }
                if (isSame){
                    for (String str : account){
                        if (name.equals(account)){
                            continue;
                        }
                        if (!accountOrigin.contains(str)){
                            accountOrigin.add(str);
                        }
                    }
                }
            }

            ret.add(account);
            nameSet.add(name);
            accountMap.put(name, index++);
        }
        return ret;
    }

    public static void main(String[] args) {
        AccountsMerge accountsMerge = new AccountsMerge();
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accountsMerge.accountsMerge(accounts);
    }
}
