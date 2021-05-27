package com.zc.leetcode;

import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

/**
 * 692. 前K个高频单词
 *
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 *
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *
 *
 *
 * 示例 2：
 *
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *
 *
 *
 * 注意：
 *
 *     假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 *     输入的单词均由小写字母组成。
 *
 *
 *
 * 扩展练习：
 *
 *     尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2021/5/20 10:32
 * @modified
 */
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordsFrequentMap = new HashMap<>();
        for (String word : words) {
            if (wordsFrequentMap.keySet().contains(word)){
                wordsFrequentMap.put(word, wordsFrequentMap.get(word)+1);
            }else {
                wordsFrequentMap.put(word, 1);
            }
        }

        List<String> collect = wordsFrequentMap.entrySet().stream()
                .sorted((a1, a2) -> a1.getValue() == a2.getValue()? a1.getKey().compareTo(a2.getKey()) : a2.getValue().compareTo(a1.getValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return collect;
    }

    //评论区看到的 steam用的6啊
    public List<String> topKFrequent2(String[] words, int k) {
        return Arrays.stream(words)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .collect(Collectors.toMap(Function.identity(), String::length))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.getValue().equals(o2.getValue())) {
                        return o1.getKey().compareTo(o2.getKey());
                    } else {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                })
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        String content = "user:\n  service:\n    url: 12256789\nserver:\n  port: 6001\nsleep: abd";
        Yaml yaml = new Yaml();
        Map<String, Object> map = (Map<String, Object>) yaml.load(content);
        System.out.println(map);
        dps(map, "");
        System.out.println(list);
    }

    private static List<String> list = new ArrayList<>();

    //dps
    private static void dps(Map<String, Object> map, String path){
        if (null == map){
            return;
        }

        if (map.size() == 1 && !(map instanceof Map)){
            if (!StringUtils.isEmpty(path)){
                path += ".";
            }
            list.add(path+"."+ map.entrySet().stream().findFirst().get().getKey());
            return;
        }

        for (Map.Entry entry : map.entrySet()){
            if ( map.get(entry.getKey()) instanceof Map){
                if (!StringUtils.isEmpty(path)){
                    path += ".";
                }
                dps((Map<String, Object>) map.get(entry.getKey()), path+entry.getKey());
            }else {
                if (!StringUtils.isEmpty(path)){
                    path += ".";
                }
                list.add(path+ entry.getKey());
            }
        }
    }
}
