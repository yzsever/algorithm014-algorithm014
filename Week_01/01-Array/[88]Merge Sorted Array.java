//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
// sorted array. 
//
// Note: 
//
// 
// The number of elements initialized in nums1 and nums2 are m and n respectivel
//y. 
// You may assume that nums1 has enough space (size that is equal to m + n) to h
//old additional elements from nums2. 
// 
//
// Example: 
//
// 
//Input:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//Output: [1,2,2,3,5,6]
// 
//
// 
// Constraints: 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics Array Two Pointers 
// 👍 2405 👎 4291


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        1、将nums2插入到nums1中，后面的元素先整体往后移动，再放入到对应的位置 T:O(n^2) S:O(1)
//        2、从后往前合并，省去移动元素的操作 T:O(n+m) S:O(1)
        int i = m - 1;
        int j = n - 1;
        int pos = n + m - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[pos] = nums1[i--];
            } else {
                nums1[pos] = nums2[j--];
            }
            pos--;
        }
        while (j >= 0) {
            nums1[pos--] = nums2[j--];
        }

//        3、先合并后排序 T：O((n+m)log(n+m)) S:O(1)
//        4、双指针从前往后合并，先将nums1拷贝一份出来。 T:O(n+m) S:O(m)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
