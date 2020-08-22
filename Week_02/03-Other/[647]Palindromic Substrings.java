//Given a string, your task is to count how many palindromic substrings in this 
//string. 
//
// The substrings with different start indexes or end indexes are counted as dif
//ferent substrings even they consist of same characters. 
//
// Example 1: 
//
// 
//Input: "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
// 
//
// 
//
// Example 2: 
//
// 
//Input: "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 
//
// Note: 
//
// 
// The input string length won't exceed 1000. 
// 
//
// Related Topics String Dynamic Programming 
// 👍 2864 👎 116


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int countSubstrings2(String s) {

        // 1、中心拓展 T:O(n^2) S:O(1)
        // - 确定中心后，向两边扩展
        // - 奇数/偶数长度的字符串
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            // 奇数
            ans += extendPalindrome(s, i, i);
            // 偶数
            ans += extendPalindrome(s, i, i + 1);
        }
        return ans;

        // 2、动态规划

    }

    private int extendPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    public int countSubstrings(String s) {

        int size = s.length();
        // 2、动态规划
        boolean[][] dp = new boolean[size][size];
        int count = 0;

        for (int i = size - 1; i >= 0; i--) {
            for (int j = i; j < size; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    count++;
                    dp[i][j] = true;
                }
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
