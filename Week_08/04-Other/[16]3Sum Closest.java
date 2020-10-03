//Given an array nums of n integers and an integer target, find three integers i
//n nums such that the sum is closest to target. Return the sum of the three integ
//ers. You may assume that each input would have exactly one solution. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics Array Two Pointers 
// 👍 2462 👎 154


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Three Pointer
    // T:O(nlogn) S:O(1)
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if (n < 3) return -1;
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[n - 1];
        for (int a = 0; a < n - 2; a++) {
            int b = a + 1, c = n - 1;
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                if (sum == target) return sum;
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum > target) {
                    c--;
                } else {
                    b++;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
