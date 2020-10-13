//Given an array of strings strs, group the anagrams together. You can return th
//e answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a differe
//nt word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2: 
// Input: strs = [""]
//Output: [[""]]
// Example 3: 
// Input: strs = ["a"]
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 104 
// 0 <= strs[i].length <= 100 
// strs[i] consists of lower-case English letters. 
// 
// Related Topics Hash Table String 
// 👍 4206 👎 201


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // String + Hash
    // T:O(n) S:O(n*len(str))
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] count = new char[26];
            for (char c : str.toCharArray()) count[c - 'a']++;
            String key = String.valueOf(count);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
