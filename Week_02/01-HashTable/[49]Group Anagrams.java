//Given an array of strings, group anagrams together. 
//
// Example: 
//
// 
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// Note: 
//
// 
// All inputs will be in lowercase. 
// The order of your output does not matter. 
// 
// Related Topics Hash Table String 
// 👍 3811 👎 194


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
//        （与242类似）
//        通过生成哈希表的key，然后将异位词放在对应的value中（list）
//        生成key的方法：
//        1、排序字符串 T:O(nklogk) S:O（nk）
/*        Map<String, List<String>> anagramsMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> anagrams = anagramsMap.get(key);
            if (anagrams == null) {
                anagrams = new ArrayList<>();
                anagramsMap.put(key, anagrams);
            }
            anagrams.add(str);
        }
        return new ArrayList<>(anagramsMap.values());*/

//        2、用26位的数组的计数器 T:O(nk) S:O（nk）
        Map<String, List<String>> anagramsMap = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                keyBuilder.append(count[i]);
            }
            String key = keyBuilder.toString();
            List<String> anagrams = anagramsMap.get(key);
            if (anagrams == null) {
                anagrams = new ArrayList<>();
                anagramsMap.put(key, anagrams);
            }
            anagrams.add(str);
        }
        return new ArrayList<>(anagramsMap.values());

    }
}
//leetcode submit region end(Prohibit modification and deletion)
