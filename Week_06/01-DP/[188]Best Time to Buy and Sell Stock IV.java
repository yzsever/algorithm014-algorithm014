//Say you have an array for which the i-th element is the price of a given stock
// on day i. 
//
// Design an algorithm to find the maximum profit. You may complete at most k tr
//ansactions. 
//
// Note: 
//You may not engage in multiple transactions at the same time (ie, you must sel
//l the stock before you buy again). 
//
// Example 1: 
//
// 
//Input: [2,4,1], k = 2
//Output: 2
//Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 
//4-2 = 2.
// 
//
// Example 2: 
//
// 
//Input: [3,2,6,5,0,3], k = 2
//Output: 7
//Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 
//6-2 = 4.
//             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), prof
//it = 3-0 = 3.
// 
// Related Topics Dynamic Programming 
// 👍 1707 👎 106


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DP T:O(n*k) S:O(n^3)
    // 分治：k>n/2 时，为不限买卖此时
    // 1、minproblems:
    // a、没有持有股票: 前一天卖出了，今天没有买 | 卖出了股票
    // b、持有股票：前一天买入了，今天没有卖 | 买入了股票, 上次卖出的收益减去本次价格
    // 2、state array dp[i][j][2]
    // 3、
    // dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1]+prices[i]);
    // dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0]-prices[i]);
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += (prices[i] - prices[i - 1]);
                }
            }
            return profit;
        }
        int m = k+1;
        int[][][] dp = new int[n][m][2];
        // init j = 0
        for (int i = 0; i < n; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        // init i = 0
        for (int j = 1; j < m; j++) {
            dp[0][j][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][m - 1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
