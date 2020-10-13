//Given an input string (s) and a pattern (p), implement regular expression matc
//hing with support for '.' and '*' where: 
//
// 
// '.' Matches any single character. 
// '*' Matches zero or more of the preceding element. 
// 
//
// The matching should cover the entire input string (not partial). 
//
// 
// Example 1: 
//
// 
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input: s = "aa", p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, 
//by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input: s = "ab", p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// Example 4: 
//
// 
//Input: s = "aab", p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, i
//t matches "aab".
// 
//
// Example 5: 
//
// 
//Input: s = "mississippi", p = "mis*is*p*."
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 20 
// 0 <= p.length <= 30 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '.', and '*'. 
// 
// Related Topics String Dynamic Programming Backtracking 
// 👍 4794 👎 764


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
    // 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
    // 3, If p.charAt(j) == '*':
    //   here are two sub conditions:
    //       1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
    //       2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
    //                      dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
    //                   or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
    //                   or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 2; j <= p.length(); j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }

        for (int j = 1; j <= p.length(); j++) {
            for (int i = 1; i <= s.length(); i++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*')
                    dp[i][j] = j - 2 >= 0 && dp[i][j - 2]
                            || (j - 2 >= 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
            }
        }
        return dp[m][n];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
