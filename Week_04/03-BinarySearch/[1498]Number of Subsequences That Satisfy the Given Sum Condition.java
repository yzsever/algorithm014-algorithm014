//Given an array of integers nums and an integer target. 
//
// Return the number of non-empty subsequences of nums such that the sum of the 
//minimum and maximum element on it is less or equal than target. 
//
// Since the answer may be too large, return it modulo 10^9 + 7. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,5,6,7], target = 9
//Output: 4
//Explanation: There are 4 subsequences that satisfy the condition.
//[3] -> Min value + max value <= target (3 + 3 <= 9)
//[3,5] -> (3 + 5 <= 9)
//[3,5,6] -> (3 + 6 <= 9)
//[3,6] -> (3 + 6 <= 9)
// 
//
// Example 2: 
//
// 
//Input: nums = [3,3,6,8], target = 10
//Output: 6
//Explanation: There are 6 subsequences that satisfy the condition. (nums can ha
//ve repeated numbers).
//[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6] 
//
// Example 3: 
//
// 
//Input: nums = [2,3,3,4,6,7], target = 12
//Output: 61
//Explanation: There are 63 non-empty subsequences, two of them don't satisfy th
//e condition ([6,7], [7]).
//Number of valid subsequences (63 - 2 = 61).
// 
//
// Example 4: 
//
// 
//Input: nums = [5,2,4,1,7,6,8], target = 16
//Output: 127
//Explanation: All non-empty subset satisfy the condition (2^7 - 1) = 127 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 1 <= target <= 10^6 
// 
// Related Topics Sort Sliding Window 
// 👍 307 👎 19


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1、排序+双指针+二分查找
    // 数组的子集的个数为2^(j-i-1)
    // 双指针确定上界
    // 二分查找确定下界
    public int numSubseq(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int ans = 0;
        int mod = 1000000007;
        // 处理余数备用
        int[] mods = new int[nums.length];
        mods[0] = 1;
        for (int i = 1; i < mods.length; i++) {
            mods[i] = (2 * mods[i - 1] + 1) % mod;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && 2 * nums[i] <= target; i++) {
            // 单个元素的数组子集
            ans = (ans + 1) % mod;
            // 子数组下界
            int left = i;
            int right = nums.length - 1;
            int mid = 0;
            while (left <= right) {
                mid = (right - left) / 2 + left;
                if (nums[i] + nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if(right > i){
                ans = (ans + mods[right - i - 1]) % mod;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
