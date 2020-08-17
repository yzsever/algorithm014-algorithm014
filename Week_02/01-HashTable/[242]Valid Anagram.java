//Given two strings s and t , write a function to determine if t is an anagram o
//f s. 
//
// Example 1: 
//
// 
//Input: s = "anagram", t = "nagaram"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "rat", t = "car"
//Output: false
// 
//
// Note: 
//You may assume the string contains only lowercase alphabets. 
//
// Follow up: 
//What if the inputs contain unicode characters? How would you adapt your soluti
//on to such case? 
// Related Topics Hash Table Sort 
// 👍 1666 👎 144


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
//        242 有效的字母异位词
//        1、将两个词排序后，判断是否相等 T:O(nlogn) S:O(1)

//        2、将一个词放入哈希表中，对应位置++，另一个词对应的位置--；最后判断哈希表是不是值都为0 T:O(n) S:O（1）
/*        int[] count = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;*/
//        3、将一个词放入哈希表中，对应位置++，另一个词对应的位置--，如果计数器小于0则返回false； T:O(n) S:O（1）
        int[] count = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (--count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
