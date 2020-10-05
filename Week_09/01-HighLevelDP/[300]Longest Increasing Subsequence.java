//Given an unsorted array of integers, find the length of longest increasing sub
//sequence. 
//
// Example: 
//
// 
//Input: [10,9,2,5,3,7,101,18]
//Output: 4 
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
//length is 4. 
//
// Note: 
//
// 
// There may be more than one LIS combination, it is only necessary for you to r
//eturn the length. 
// Your algorithm should run in O(n2) complexity. 
// 
//
// Follow up: Could you improve it to O(n log n) time complexity? 
// Related Topics Binary Search Dynamic Programming 
// 👍 5538 👎 124


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DP
    // if(nums[i] >= nums[j]) dp[i] = max(dp[j])+1;  i>j
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            int maxInterval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxInterval = Math.max(maxInterval, dp[j]);
                }
            }
            dp[i] = maxInterval + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
