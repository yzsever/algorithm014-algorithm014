//Given a positive integer n, find the least number of perfect square numbers (f
//or example, 1, 4, 9, 16, ...) which sum to n. 
//
// Example 1: 
//
// 
//Input: n = 12
//Output: 3 
//Explanation: 12 = 4 + 4 + 4. 
//
// Example 2: 
//
// 
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9. Related Topics Math Dynamic Programming Breadth-first
// Search 
// 👍 3460 👎 211


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // dp[i] = Math.min(dp[i], dp[i - square[j]] + 1);
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int maxSquare = (int) Math.sqrt(n) + 1;
        int[] square = new int[maxSquare];
        for (int i = 1; i < maxSquare; i++) {
            square[i] = i * i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < maxSquare; j++) {
                if (i < square[j]) break;
                dp[i] = Math.min(dp[i], dp[i - square[j]] + 1);
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class Solution { public int numSquares(int n) { int dp[] = new int[n + 1]; Arrays.fill(dp, Integer.MAX_VALUE); // bottom case
// dp[0] = 0; // pre-calculate the square numbers.
// int max_square_index = (int) Math.sqrt(n) + 1; int square_nums[] = new int[max_square_index];
// for (int i = 1; i < max_square_index; ++i) { square_nums[i] = i * i; }
//
    for (int i = 1; i <= n; ++i) {
        for (int s = 1; s < max_square_index; ++s) {
            if (i < square_nums[s]) break;
            dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
        }
    }
    return dp[n];
}
