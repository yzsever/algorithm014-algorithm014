//Given a triangle, find the minimum path sum from top to bottom. Each step you 
//may move to adjacent numbers on the row below. 
//
// For example, given the following triangle 
//
// 
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
//
// Note: 
//
// Bonus point if you are able to do this using only O(n) extra space, where n i
//s the total number of rows in the triangle. 
// Related Topics Array Dynamic Programming 
// 👍 2205 👎 260


import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1、暴力，递归 2^n
    // 2、DP
    // - a、重复性(分治) problem(i,j) = min(sub(i+1,j), sub(i+1, j+1))+a[i,j]
    // - b、定义状态数组 dp[i,j]
    // - c、DP方程 dp[i,j] = min(dp[i+1,j], dp[i+1,j+1])+ a[i,j]
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int size = triangle.size();
        List<Integer> bottom = triangle.get(size - 1);
        int bottomSize = bottom.size();
        int[] dp = new int[bottomSize];
        for (int i = 0; i < bottomSize; i++) {
            dp[i] = bottom.get(i);
        }
        for (int i = size - 2; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[j] = Math.min(rows.get(j) + dp[j], rows.get(j) + dp[j + 1]);
            }
        }
        return dp[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
