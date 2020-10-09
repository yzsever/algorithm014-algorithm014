//Given a string S and a string T, count the number of distinct subsequences of 
//S which equals T. 
//
// A subsequence of a string is a new string which is formed from the original s
//tring by deleting some (can be none) of the characters without disturbing the re
//lative positions of the remaining characters. (ie, "ACE" is a subsequence of "AB
//CDE" while "AEC" is not). 
//
// It's guaranteed the answer fits on a 32-bit signed integer. 
//
// Example 1: 
//
// 
//Input: S = "rabbbit", T = "rabbit"
//Output: 3
//Explanation:
//As shown below, there are 3 ways you can generate "rabbit" from S.
//(The caret symbol ^ means the chosen letters)
//
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
// 
//
// Example 2: 
//
// 
//Input: S = "babgbag", T = "bag"
//Output: 5
//Explanation:
//As shown below, there are 5 ways you can generate "bag" from S.
//(The caret symbol ^ means the chosen letters)
//
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^
// 
// Related Topics String Dynamic Programming 
// 👍 1507 👎 59


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DP T:O(n*m) T:O(n*m)
    // Subproblem:
    // - if T[i] == S[j] , dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
    //    - 保留S[j]，有dp[i-1][j-1]种方法。即：确定S的第j个字符与t的第i个字符对应后，S的前 j-1 个字符有多少种方法变为T的前 i-1 个字符。
    //    - 不保留s[j]，有dp[i-1][j]种方法。即：不使用S的第j个字符，S的前 j-1 个字符有多少种方法变为T的前 i 个字符。
    // - if T[i] != S[j] , dp[i][j] = dp[i][j-1]
    // State Array: dp[T+1][S+1] dp[i][j] 代表T前i字符串可以由S前j字符串组成最多个数.
    // - init dp[0][j] = 1;
    public int numDistinct(String s, String t) {
        int m = t.length();
        int n = s.length();
        int[][] dp = new int[m+1][n+1];
        Arrays.fill(dp[0], 1);
        for(int i=1; i<=t.length(); i++){
            for(int j=1; j<=s.length(); j++){
                if(t.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
