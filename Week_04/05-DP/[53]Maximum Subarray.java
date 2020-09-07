//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum. 
//
// Follow up: If you have figured out the O(n) solution, try coding another solu
//tion using the divide and conquer approach, which is more subtle. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [0]
//Output: 0
// 
//
// Example 4: 
//
// 
//Input: nums = [-1]
//Output: -1
// 
//
// Example 5: 
//
// 
//Input: nums = [-2147483647]
//Output: -2147483647
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics Array Divide and Conquer Dynamic Programming 
// 👍 8779 👎 412


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1、暴力 T:O(n^2)
    // 2、DP
    // - a、分治（子问题）：max_sum(i) = Max(max_sum(i-1), 0)+a[i]
    // - b、状态数组定义：dp[i]
    // - c、DP方程：dp[i] = Math.max(dp[i-1], 0)+a[i]
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
