//Given an integer n, write a function to determine if it is a power of two. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: true
//Explanation: 20 = 1
// 
//
// Example 2: 
//
// 
//Input: n = 16
//Output: true
//Explanation: 24 = 16
// 
//
// Example 3: 
//
// 
//Input: n = 3
//Output: false
// 
//
// Example 4: 
//
// 
//Input: n = 4
//Output: true
// 
//
// Example 5: 
//
// 
//Input: n = 5
//Output: false
// 
//
// 
// Constraints: 
//
// 
// -231 <= n <= 231 - 1 
// 
// Related Topics Math Bit Manipulation 
// 👍 1034 👎 203


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Bit Manipulation
    // 2的次方表明二进制中只有一个1，清掉最低位的1则等于0
    // T:O(1) S:O(1)
    public boolean isPowerOfTwo(int n) {
        return (n > 0 && ((n & (n - 1)) == 0));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
