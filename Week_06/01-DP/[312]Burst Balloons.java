//Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number
// on it represented by array nums. You are asked to burst all the balloons. If th
//e you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Her
//e left and right are adjacent indices of i. After the burst, the left and right 
//then becomes adjacent. 
//
// Find the maximum coins you can collect by bursting the balloons wisely. 
//
// Note: 
//
// 
// You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can n
//ot burst them. 
// 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100 
// 
//
// Example: 
//
// 
//Input: [3,1,5,8]
//Output: 167 
//Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
// Related Topics Divide and Conquer Dynamic Programming 
// 👍 2677 👎 69


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1、记忆化搜索 T:O(n^3) S:O(n^2)
    // 缓存
    public int[][] rec;
    public int[] val;

    public int maxCoins1(int[] nums) {
        int n = nums.length;
        val = new int[n + 2];
        // 初始化值
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        // 增加数据处理边界问题
        val[0] = val[n + 1] = 1;
        rec = new int[n+2][n+2];
        for (int i = 0; i <= n + 1; i++) {
            Arrays.fill(rec[i], -1);
        }
        return addCoin(0, n + 1);
    }

    private int addCoin(int left, int right) {
        if (left >= right - 1) {
            return 0;
        }
        if (rec[left][right] != -1) {
            return rec[left][right];
        }
        for (int i = left + 1; i < right; i++) {
            int sum = val[left] * val[i] * val[right];
            sum += addCoin(left, i) + addCoin(i, right);
            rec[left][right] = Math.max(rec[left][right], sum);
        }
        return rec[left][right];
    }

    // 2、DP
    // A、拆分子问题 找到i，j区间内填充气球的最大值
    // B、状态数组 dp[i][j]
    // C、状态转移方程 dp[i][j] = Math.max(dp[i][j], sum)
    // i需要倒序遍历
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        return dp[0][n + 1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
