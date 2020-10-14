//Given an input string (s) and a pattern (p), implement wildcard pattern matchi
//ng with support for '?' and '*'. 
//
// 
//'?' Matches any single character.
//'*' Matches any sequence of characters (including the empty sequence).
// 
//
// The matching should cover the entire input string (not partial). 
//
// Note: 
//
// 
// s could be empty and contains only lowercase letters a-z. 
// p could be empty and contains only lowercase letters a-z, and characters like
// ? or *. 
// 
//
// Example 1: 
//
// 
//Input:
//s = "aa"
//p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input:
//s = "aa"
//p = "*"
//Output: true
//Explanation: '*' matches any sequence.
// 
//
// Example 3: 
//
// 
//Input:
//s = "cb"
//p = "?a"
//Output: false
//Explanation: '?' matches 'c', but the second letter is 'a', which does not mat
//ch 'b'.
// 
//
// Example 4: 
//
// 
//Input:
//s = "adceb"
//p = "*a*b"
//Output: true
//Explanation: The first '*' matches the empty sequence, while the second '*' ma
//tches the substring "dce".
// 
//
// Example 5: 
//
// 
//Input:
//s = "acdcb"
//p = "a*c?b"
//Output: false
// 
// Related Topics String Dynamic Programming Backtracking Greedy 
// 👍 2381 👎 114


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // The most confusing part for me is how to deal with '*'.
    // At first I couldn't figure out why the condition would be (dp[i-1][j] == true || dp[i][j-1] == true).
    // Hope detailed DP description below helps!
    //
    // dp[i][j]: true if the first i char in String s matches the first j chars in String p
    // Base case:
    // origin: dp[0][0]: they do match, so dp[0][0] = true
    // first row: dp[0][j]: except for String p starts with *, otherwise all false
    // first col: dp[i][0]: can't match when p is empty. All false.
    //
    // Recursion:
    // Iterate through every dp[i][j]
    // dp[i][j] = true:
    // if (s[ith] == p[jth] || p[jth] == '?') && dp[i-1][j-1] == true
    // elif p[jth] == '*' && (dp[i-1][j] == true || dp[i][j-1] == true)
    //  -for dp[i-1][j], means that * acts like an empty sequence.
    //  eg: ab, ab*
    //  -for dp[i][j-1], means that * acts like any sequences
    //  eg: abcd, ab*
    //
    // Start from 0 to len
    // Output put should be dp[s.len][p.len], referring to the whole s matches the whole p
    // Be careful about the difference of index i,j in String (0 to len-1) and the index i, j in dp (0 to len)!
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int sl = s.length();
        int pl = p.length();
        boolean[][] dp = new boolean[sl + 1][pl + 1];
        // dp[i][j]: true if the first i char in String s matches the first j chars in String p
        // Base case:
        // origin: dp[0][0]: they do match, so dp[0][0] = true
        // first row: dp[0][j]: except for String p starts with *, otherwise all false
        // first col: dp[i][0]: can't match when p is empty. All false.
        dp[0][0] = true;
        for (int j = 1; j <= pl; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        // Iterate through every dp[i][j]
        // dp[i][j] = true:
        // if (s[ith] == p[jth] || p[jth] == '?') && dp[i-1][j-1] == true
        // elif p[jth] == '*' && (dp[i-1][j] == true || dp[i][j-1] == true)
        //  -for dp[i-1][j], means that * acts like an empty sequence.
        //  eg: ab, ab*
        //  -for dp[i][j-1], means that * acts like any sequences
        //  eg: abcd, ab*
        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                if ((s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') && dp[i - 1][j - 1]) {
                    dp[i][j] = true;
                } else if (p.charAt(j - 1) == '*' && (dp[i - 1][j] || dp[i][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[sl][pl];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
