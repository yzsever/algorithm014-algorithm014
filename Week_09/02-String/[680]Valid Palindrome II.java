//
//Given a non-empty string s, you may delete at most one character. Judge whethe
//r you can make it a palindrome.
// 
//
// Example 1: 
// 
//Input: "aba"
//Output: True
// 
// 
//
// Example 2: 
// 
//Input: "abca"
//Output: True
//Explanation: You could delete the character 'c'.
// 
// 
//
// Note: 
// 
// The string will only contain lowercase characters a-z.
//The maximum length of the string is 50000. 
// 
// Related Topics String 
// 👍 1980 👎 129


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Two Pointer
    // T:O(n) S:O(1)
    public boolean validPalindrome(String s) {
        if (s == null || s.length() < 1) return false;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isPalindrome(String s, int l, int r) {
        if (l > r) return false;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
