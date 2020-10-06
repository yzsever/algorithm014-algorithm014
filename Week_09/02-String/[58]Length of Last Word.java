//Given a string s consists of upper/lower-case alphabets and empty space charac
//ters ' ', return the length of last word (last word means the last appearing wor
//d if we loop from left to right) in the string. 
//
// If the last word does not exist, return 0. 
//
// Note: A word is defined as a maximal substring consisting of non-space charac
//ters only. 
//
// Example: 
//
// 
//Input: "Hello World"
//Output: 5
// 
//
// 
// Related Topics String 
// 👍 810 👎 2766


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // String
    // T:O(n) S:O(1)
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int len = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                 if(len != 0) return len;
            } else {
                len++;
            }
        }
        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
