//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed. All houses at this place are arranged i
//n a circle. That means the first house is the neighbor of the last one. Meanwhil
//e, adjacent houses have security system connected and it will automatically cont
//act the police if two adjacent houses were broken into on the same night. 
//
// Given a list of non-negative integers representing the amount of money of eac
//h house, determine the maximum amount of money you can rob tonight without alert
//ing the police. 
//
// Example 1: 
//
// 
//Input: [2,3,2]
//Output: 3
//Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 
//2),
//             because they are adjacent houses.
// 
//
// Example 2: 
//
// 
//Input: [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4. 
// Related Topics Dynamic Programming 
// 👍 2000 👎 52


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DP T：O(n) S:O(1)
    // 将问题转换成两个robber house问题，由于第一家和最后一家不能同时偷，则将数组转化成[0-n-2]和[1-n-1],再获得较大值
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        return Math.max(robHelper(nums, 0, n - 2), robHelper(nums, 1, n - 1));
    }

    // dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i])
    private int robHelper(int[] nums, int start, int end) {
        int include = 0, exclude = 0;
        for (int i = start; i <= end; i++) {
            int in = include, ex = exclude;
            include = ex + nums[i];
            exclude = Math.max(ex, in);
        }
        return Math.max(include, exclude);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
