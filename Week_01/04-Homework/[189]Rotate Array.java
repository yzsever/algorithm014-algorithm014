//Given an array, rotate the array to the right by k steps, where k is non-negat
//ive. 
//
// Follow up: 
//
// 
// Try to come up as many solutions as you can, there are at least 3 different w
//ays to solve this problem. 
// Could you do it in-place with O(1) extra space? 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation: 
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10^4 
// It's guaranteed that nums[i] fits in a 32 bit-signed integer. 
// k >= 0 
// 
// Related Topics Array 
// 👍 3013 👎 830


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
//        1、暴力，一次次的将最后一个元素移动到开头 T:O(Nk) S:O(1)

//        2、使用链表存储数组进行翻转 T:O(k) S:O(N)

//        3、创建一个新的数组，安照新的顺序将元素放进去 T:O(N) S:O(N)

//        4、使用环状替换 T:O(N) S:O(1)
//                - 将所有i%k==0的元素替换一轮位置，直到返回到开始位置
//                - 然后i++替换新的一轮，直到回到开始位置。
//        - 移动元素数量为数组长度时结束
        int n = nums.length;
        k = k % n;
        int count = 0;
        for (int start = 0; count < n; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int tmp = prev;
                prev = nums[next];
                nums[next] = tmp;
                current = next;
                count ++;
            } while (start != current);
        }


//        5、使用反转 T:O(N) S:O(1) 将所有元素翻转后，将前k个元素翻转，再将后n-k个元素翻转
/*        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);*/
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
