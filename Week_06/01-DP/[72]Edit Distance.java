//Given two words word1 and word2, find the minimum number of operations require
//d to convert word1 to word2. 
//
// You have the following 3 operations permitted on a word: 
//
// 
// Insert a character 
// Delete a character 
// Replace a character 
// 
//
// Example 1: 
//
// 
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation: 
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
// 
//
// Example 2: 
//
// 
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation: 
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
// 
// Related Topics String Dynamic Programming 
// 👍 4394 👎 59


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    DP T：O（mn） S：O（mn）
//    1、subproblem
//    Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.
//    f(i, j) = f(i - 1, j - 1)
//    Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper
//    f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
//    f(i, j - 1) represents insert operation
//    f(i - 1, j) represents delete operation
//    f(i - 1, j - 1) represents replace operation
//    2、state array
//    f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2
//    3、DP 方程
//    Base Case: f(0, k) = f(k, 0) = k
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // init dp
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i - 1][j];
                    int delete = dp[i][j - 1];
                    int replace = dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
