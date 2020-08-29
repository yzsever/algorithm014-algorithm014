//Implement int sqrt(int x). 
//
// Compute and return the square root of x, where x is guaranteed to be a non-ne
//gative integer. 
//
// Since the return type is an integer, the decimal digits are truncated and onl
//y the integer part of the result is returned. 
//
// Example 1: 
//
// 
//Input: 4
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since 
//             the decimal part is truncated, 2 is returned.
// 
// Related Topics Math Binary Search 
// 👍 1433 👎 1973


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1、二分查找 T:O(n) S:O(1)
    public int mySqrt(int x) {
        int low = 0;
        int high = x / 2 == 0 && x % 2 == 0 ? x / 2 : x / 2 + 1;
        int mid = 0, ans = 0;
        while (low <= high) {
            mid = (high - low) / 2 + low;
            long num = (long) mid * mid;
            if (num == x) {
                return mid;
            }
            if (num < x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
