//You are given coins of different denominations and a total amount of money amo
//unt. Write a function to compute the fewest number of coins that you need to mak
//e up that amount. If that amount of money cannot be made up by any combination o
//f the coins, return -1. 
//
// Example 1: 
//
// 
//Input: coins = [1, 2, 5], amount = 11
//Output: 3 
//Explanation: 11 = 5 + 5 + 1 
//
// Example 2: 
//
// 
//Input: coins = [2], amount = 3
//Output: -1
// 
//
// Note: 
//You may assume that you have an infinite number of each kind of coin. 
// Related Topics Dynamic Programming 
// 👍 4730 👎 147


import java.util.Arrays;
import java.util.Collections;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1 Greedy+DFS
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int ans = coinChangeHelper(coins, amount, coins.length - 1, 0, Integer.MAX_VALUE);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int coinChangeHelper(int[] coins, int amount, int pos, int count, int ans) {
        // terminator
        if (amount == 0) {
            ans = Math.min(ans, count);
            return ans;
        }
        if (pos < 0) {
            return Integer.MAX_VALUE;
        }
        // process current logic
        // drill down
        for (int i = amount / coins[pos]; i >= 0 && i + count < ans; i--) {
            int newAns = coinChangeHelper(coins, amount - i * coins[pos], pos - 1, i + count, ans);
            ans = Math.min(ans, newAns);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
