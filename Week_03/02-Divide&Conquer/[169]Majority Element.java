//Given an array of size n, find the majority element. The majority element is t
//he element that appears more than ⌊ n/2 ⌋ times. 
//
// You may assume that the array is non-empty and the majority element always ex
//ist in the array. 
//
// Example 1: 
//
// 
//Input: [3,2,3]
//Output: 3 
//
// Example 2: 
//
// 
//Input: [2,2,1,1,1,2,2]
//Output: 2
// 
// Related Topics Array Divide and Conquer Bit Manipulation 
// 👍 3467 👎 226


import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    1、哈希表 T：O(n) S:O(n)
//    - 统计所有元素出现的个数，再遍历哈希表找出出现次数最多的元素
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }


//    2、排序 T：O(nlogn) S：O(logn)
//    - 有序数组中间一个元素就是多数元素
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


//    3、分治 T：O(nlogn) S：O(logn)
//    - 如果数 a 是数组 nums 的众数，如果我们将 nums 分成两部分，那么 a 必定是至少一部分的众数
    public int majorityElement(int[] nums) {
        return divideConquer(nums, 0, nums.length-1);
    }

    public int divideConquer(int[] nums, int low, int high){
        // terminator
        if(low == high){
            return nums[low];
        }

        // prepare data
        int mid = (high-low)/2+low;

        // conquer subproblems
        int left = divideConquer(nums, low, mid);
        int right = divideConquer(nums, mid+1, high);

        // process and generate the final result
        if(left == right){
            return left;
        }

        int leftCount = countElement(nums, low, mid, left);
        int rightCount = countElement(nums, mid+1, high, right);
        return leftCount > rightCount ? left : right;
        // revert the current level states
    }

    private int countElement(int[] nums, int start, int end, int num){
        int count = 0;
        for(int i = start; i<= end; i++){
            if(nums[i] == num){
                count++;
            }
        }
        return count;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
