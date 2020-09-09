//Given an integer array nums, find the contiguous subarray within an array (con
//taining at least one number) which has the largest product. 
//
// Example 1: 
//
// 
//Input: [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
// 
//
// Example 2: 
//
// 
//Input: [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray. 
// Related Topics Array Dynamic Programming 
// 👍 4709 👎 169


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1 subproblem(i): if a[i] > 0 = Max(max[i-1]*a[i], a[i]);
    // if a[i] < 0 = Max(min[i-1*a[i], a[i]);
    // 2 state array: maxdp, mindp
    // 3 maxdp,mindp
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = max;
        int maxProd = max;
        for (int i = 1; i < nums.length; i++) {
            int toMax = max * nums[i];
            int toMin = min * nums[i];
            max = Math.max(Math.max(toMax, toMin), nums[i]);
            min = Math.min(Math.min(toMax, toMin), nums[i]);
            maxProd = Math.max(max, maxProd);
        }
        return maxProd;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
