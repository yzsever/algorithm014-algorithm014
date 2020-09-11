//Say you have an array for which the ith element is the price of a given stock 
//on day i. 
//
// Design an algorithm to find the maximum profit. You may complete at most two 
//transactions. 
//
// Note: You may not engage in multiple transactions at the same time (i.e., you
// must sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: prices = [3,3,5,0,0,3,1,4]
//Output: 6
//Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 
//3-0 = 3.
//Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
// 
//
// Example 2: 
//
// 
//Input: prices = [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 
//5-1 = 4.
//Note that you cannot buy on day 1, buy on day 2 and sell them later, as you ar
//e engaging multiple transactions at the same time. You must sell before buying a
//gain.
// 
//
// Example 3: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
// 
//
// Example 4: 
//
// 
//Input: prices = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 105 
// 
// Related Topics Array Dynamic Programming 
// 👍 2599 👎 78


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DP T:O(n) S:O(n^3)
    // 1、minproblems:
    // a、没有持有股票: 前一天卖出了，今天没有买 | 卖出了股票
    // b、持有股票：前一天买入了，今天没有卖 | 买入了股票, 上次卖出的收益减去本次价格
    // 2、state array dp[i][2][2]
    // 3、
    // dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1]+prices[i]);
    // dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0]-prices[i]);
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int k = 3;
        int[][][] dp = new int[n][k][2];
        // init j=0
        for (int i = 0; i < n; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        // init i=0
        for (int j = 1; j < k; j++) {
            dp[0][j][1] = -prices[0];
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<k; j++){
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1]+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0]-prices[i]);
            }
        }
        return dp[n-1][k-1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
