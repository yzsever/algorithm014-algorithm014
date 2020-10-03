//Given an array of non-negative integers, you are initially positioned at the f
//irst index of the array. 
//
// Each element in the array represents your maximum jump length at that positio
//n. 
//
// Determine if you are able to reach the last index. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum jum
//p length is 0, which makes it impossible to reach the last index.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10^4 
// 0 <= nums[i][j] <= 10^5 
// 
// Related Topics Array Greedy 
// 👍 4876 👎 363


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DP
    // 子问题：计算每次可以跳到的最远距离
    // state Array dp[i]
    // DP方程：dp[i] = Math.max(i+nums[i], max);
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n < 1) return false;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i > max) return false;
            max = Math.max(i + nums[i], max);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
