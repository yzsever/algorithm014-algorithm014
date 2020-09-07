//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// Find the minimum element. 
//
// You may assume no duplicate exists in the array. 
//
// Example 1: 
//
// 
//Input: [3,4,5,1,2] 
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: [4,5,6,7,0,1,2]
//Output: 0
// 
// Related Topics Array Binary Search 
// 👍 2478 👎 253


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1、BinarySearch T:O(n) S:O(1)
    // - 如果mid大于前一个元素，则为最小
    // - 如果mid大于left和right的元素，则最小值在mid的右边，否则在左边
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] >= nums[left] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    // 2、BinarySearch T:O(n) S:O(1)
    // - 如果mid大于最右元素，则最小值在右边
    public int findMin2(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
