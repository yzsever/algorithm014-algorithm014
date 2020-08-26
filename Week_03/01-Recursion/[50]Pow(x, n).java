//Implement pow(x, n), which calculates x raised to the power n (i.e. xn). 
//
// 
// Example 1: 
//
// 
//Input: x = 2.00000, n = 10
//Output: 1024.00000
// 
//
// Example 2: 
//
// 
//Input: x = 2.10000, n = 3
//Output: 9.26100
// 
//
// Example 3: 
//
// 
//Input: x = 2.00000, n = -2
//Output: 0.25000
//Explanation: 2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
// Constraints: 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics Math Binary Search 
// 👍 1686 👎 3202


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    1、递归+快速幂 T:O(logn) S:O(logn)
    public double myPow(double x, int n) {
        // terminator
        if (n == 0) {
            return 1.0;
        }
        // process current logic
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            n = -n;
            x = 1.0 / x;
        }
        // drill down
        return n % 2 == 0 ? myPow(x * x, n / 2) : x*myPow(x * x, n / 2);
        // restore current status
    }
}
//leetcode submit region end(Prohibit modification and deletion)
