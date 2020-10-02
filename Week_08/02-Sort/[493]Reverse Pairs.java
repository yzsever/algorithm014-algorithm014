//Given an array nums, we call (i, j) an important reverse pair if i < j and num
//s[i] > 2*nums[j]. 
//
// You need to return the number of important reverse pairs in the given array. 
//
//
// Example1:
// 
//Input: [1,3,2,3,1]
//Output: 2
// 
//
// Example2:
// 
//Input: [2,4,3,5,1]
//Output: 3
// 
//
// Note: 
// 
// The length of the given array will not exceed 50,000. 
// All the numbers in the input array are in the range of 32-bit integer. 
// 
// Related Topics Binary Search Divide and Conquer Sort Binary Indexed Tree Segm
//ent Tree 
// 👍 972 👎 123


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Merge Sort
    // T:O(nlogn) S:O(n)
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }


    public int mergeSort(int[] array, int left, int right) {
        if (right <= left) return 0;
        int mid = (left + right) >> 1; // (left + right) / 2
        int count = mergeSort(array, left, mid) + mergeSort(array, mid + 1, right);
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && array[i] / 2.0 > array[j]) j++;
            count += j - (mid + 1);
        }
        merge(array, left, mid, right);
        return count;
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 中间数组
        int i = left, j = mid + 1, k = 0;
        int count = 0;
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
        // 也可以用 System.arraycopy(a, start1, b, start2, length)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
