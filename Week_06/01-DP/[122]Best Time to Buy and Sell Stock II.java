//Say you have an array prices for which the ith element is the price of a given
// stock on day i. 
//
// Design an algorithm to find the maximum profit. You may complete as many tran
//sactions as you like (i.e., buy one and sell one share of the stock multiple tim
//es). 
//
// Note: You may not engage in multiple transactions at the same time (i.e., you
// must sell the stock before you buy again). 
//
// Example 1: 
//
// 
//Input: [7,1,5,3,6,4]
//Output: 7
//Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 
//5-1 = 4.
//             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), prof
//it = 6-3 = 3.
// 
//
// Example 2: 
//
// 
//Input: [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 
//5-1 = 4.
//             Note that you cannot buy on day 1, buy on day 2 and sell them lat
//er, as you are
//             engaging multiple transactions at the same time. You must sell be
//fore buying again.
// 
//
// Example 3: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0. 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 3 * 10 ^ 4 
// 0 <= prices[i] <= 10 ^ 4 
// 
// Related Topics Array Greedy 
// 👍 2818 👎 1803


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DP T:O(n) S:O(n^2)
    // 1、minproblems:
    // a、没有持有股票: 前一天卖出了，今天没有买 | 卖出了股票
    // b、持有股票：前一天买入了，今天没有卖 | 买入了股票
    // 2、state array dp[i][2]
    // 3、
    // dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
    // dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
