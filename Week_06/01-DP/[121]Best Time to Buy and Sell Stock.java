//Say you have an array for which the ith element is the price of a given stock 
//on day i. 
//
// If you were only permitted to complete at most one transaction (i.e., buy one
// and sell one share of the stock), design an algorithm to find the maximum profi
//t. 
//
// Note that you cannot sell a stock before you buy one. 
//
// Example 1: 
//
// 
//Input: [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//             Not 7-1 = 6, as selling price needs to be larger than buying pric
//e.
// 
//
// Example 2: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
// 
// Related Topics Array Dynamic Programming 
// 👍 5919 👎 256


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 1 subproblem(i) = max(dp[i-1], prices-minprices)
    // 2 state array dp[i]
    // 3 dp[i]=max(dp[i−1],prices[i]−minprice)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        int minPrice = prices[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return dp[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
