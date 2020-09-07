//Given an array nums of n integers and an integer target, are there elements a,
// b, c, and d in nums such that a + b + c + d = target? Find all unique quadruple
//ts in the array which gives the sum of target. 
//
// Note: 
//
// The solution set must not contain duplicate quadruplets. 
//
// Example: 
//
// 
//Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//
//A solution set is:
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics Array Hash Table Two Pointers 
// 👍 2228 👎 345


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1、Two pointer
    // 和三数之和采用的方法一致
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length < 4) {
            return results;
        }
        Arrays.sort(nums);
        for (int a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (int b = a + 1; b < nums.length - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                int c = b + 1, d = nums.length - 1;
                int sum = target - nums[a] - nums[b];
                while (c < d) {
                    if (nums[c] + nums[d] == sum) {
                        results.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        while (c < d && nums[c] == nums[++c]) ;
                        while (c < d && nums[d] == nums[--d]) ;
                        continue;
                    }
                    if (nums[c] + nums[d] < sum) {
                        c++;
                    } else {
                        d--;
                    }
                }
            }
        }
        return results;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
