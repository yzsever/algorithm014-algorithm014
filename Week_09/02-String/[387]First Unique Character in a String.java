//Given a string, find the first non-repeating character in it and return its in
//dex. If it doesn't exist, return -1. 
//
// Examples: 
//
// 
//s = "leetcode"
//return 0.
//
//s = "loveleetcode"
//return 2.
// 
//
// 
//
// Note: You may assume the string contains only lowercase English letters. 
// Related Topics Hash Table String 
// 👍 2255 👎 124


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // String
    // T:O(n) S:O(1)
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (count[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
