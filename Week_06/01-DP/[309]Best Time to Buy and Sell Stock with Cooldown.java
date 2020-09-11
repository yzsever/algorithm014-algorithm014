//Say you have an array for which the ith element is the price of a given stock 
//on day i. 
//
// Design an algorithm to find the maximum profit. You may complete as many tran
//sactions as you like (ie, buy one and sell one share of the stock multiple times
//) with the following restrictions: 
//
// 
// You may not engage in multiple transactions at the same time (ie, you must se
//ll the stock before you buy again). 
// After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 
//day) 
// 
//
// Example: 
//
// 
//Input: [1,2,3,0,2]
//Output: 3 
//Explanation: transactions = [buy, sell, cooldown, buy, sell]
// Related Topics Dynamic Programming 
// 👍 2886 👎 90


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DP T:O(n) S:O(n^2)
    // 1、minproblems:
    // a、没有持有股票: 前一天卖出了，今天冷静期不能买 | 卖出了股票 | 前两天卖出了，今天没有买
    // b、持有股票：前一天买入了，今天没有卖 | 冷静了一天买入了股票
    // 2、state array dp[i][2]
    // 3、
    // dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
    // dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]-prices[i]);
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
