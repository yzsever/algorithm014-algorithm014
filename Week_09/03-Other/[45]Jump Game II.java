//Given an array of non-negative integers, you are initially positioned at the f
//irst index of the array. 
//
// Each element in the array represents your maximum jump length at that positio
//n. 
//
// Your goal is to reach the last index in the minimum number of jumps. 
//
// Example: 
//
// 
//Input: [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2.
//    Jump 1 step from index 0 to 1, then 3 steps to the last index. 
//
// Note: 
//
// You can assume that you can always reach the last index. 
// Related Topics Array Greedy 
// 👍 3070 👎 155


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // maxPosition = Math.max(maxPosition, i+nums[i])
    // dp[i] = Math.min(dp[j])+1
    public int jump(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int maxPosition = 0, step = 0, end = 0;
        for (int i = 0; i < n - 1; i++) {
            if (i <= maxPosition) {
                maxPosition = Math.max(maxPosition, i + nums[i]);
                if (i == end) {
                    step++;
                    end = maxPosition;
                }
            } else {
                return -1;
            }
        }
        return step;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
