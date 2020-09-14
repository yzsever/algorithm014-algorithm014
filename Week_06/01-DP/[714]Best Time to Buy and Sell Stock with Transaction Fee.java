//Your are given an array of integers prices, for which the i-th element is the 
//price of a given stock on day i; and a non-negative integer fee representing a t
//ransaction fee. 
// You may complete as many transactions as you like, but you need to pay the tr
//ansaction fee for each transaction. You may not buy more than 1 share of a stock
// at a time (ie. you must sell the stock share before you buy again.) 
// Return the maximum profit you can make. 
//
// Example 1: 
// 
//Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
//Output: 8
//Explanation: The maximum profit can be achieved by:
// Buying at prices[0] = 1 Selling at prices[3] = 8 Buying at prices[4] = 4 Sell
//ing at prices[5] = 9 The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
// 
// 
//
// Note:
// 0 < prices.length <= 50000. 
// 0 < prices[i] < 50000. 
// 0 <= fee < 50000. 
// Related Topics Array Dynamic Programming Greedy 
// 👍 1730 👎 51


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DP T:O(n) S:O(n^2)
    // 1、minproblems:
    // a、没有持有股票: 前一天卖出了，今天没有买 | 卖出了股票
    // b、持有股票：前一天买入了，今天没有卖 | 买入了股票
    // 2、state array dp[i][2]
    // 3、
    // dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]-fee);
    // dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
