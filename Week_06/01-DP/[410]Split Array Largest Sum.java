//Given an array nums which consists of non-negative integers and an integer m, 
//you can split the array into m non-empty continuous subarrays. 
//
// Write an algorithm to minimize the largest sum among these m subarrays. 
//
// 
// Example 1: 
//
// 
//Input: nums = [7,2,5,10,8], m = 2
//Output: 18
//Explanation:
//There are four ways to split nums into two subarrays.
//The best way is to split it into [7,2,5] and [10,8],
//where the largest sum among the two subarrays is only 18.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4,5], m = 2
//Output: 9
// 
//
// Example 3: 
//
// 
//Input: nums = [1,4,4], m = 3
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 106 
// 1 <= m <= min(50, nums.length) 
// 
// Related Topics Binary Search Dynamic Programming 
// 👍 2010 👎 78


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    DP T:O(m*n^2) S:O(mn)
//    本题中，我们可以令 f[i][j] 表示将数组的前 i 个数分割为 j段所能得到的最大连续子数组和的最小值。
//    在进行状态转移时，我们可以考虑第 j 段的具体范围，即我们可以枚举 k，其中前 k个数被分割为 j−1 段，而第 k+1 到第 i 个数为第 j 段。
//    此时，这 j 段子数组中和的最大值，就等于 f[k][j−1] 与 sub(k+1,i) 中的较大值，其中 sub(i,j) 表示数组 nums中下标落在区间 [i,j]内的数的和。
//    由于我们要使得子数组中和的最大值最小，因此可以列出如下的状态转移方程：
//    f[i][j]=min{f[i][j], max(f[k][j−1],sub(k+1,i))}
//    对于状态 f[i][j]，由于我们不能分出空的子数组，因此合法的状态必须有 i≥j。对于不合法（i<j）的状态，由于我们的目标是求出最小值，
//    因此可以将这些状态全部初始化为一个很大的数。在上述的状态转移方程中，一旦我们尝试从不合法的状态 f[k][j−1] 进行转移，
//    那么 max⁡(⋯ )将会是一个很大的数，就不会对最外层的 min⁡{⋯ } 产生任何影响。
//    f[0][0]=0。
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        if (n == 0) return 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        int[] sub = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sub[i] = sub[i - 1] + nums[i-1];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return dp[n][m];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
