//Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rec
//tangle in the matrix such that its sum is no larger than k. 
//
// Example: 
//
// 
//Input: matrix = [[1,0,1],[0,-2,3]], k = 2
//Output: 2 
//Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
//             and 2 is the max number no larger than k (k = 2). 
//
// Note: 
//
// 
// The rectangle inside the matrix must have an area > 0. 
// What if the number of rows is much larger than the number of columns? 
// Related Topics Binary Search Dynamic Programming Queue 
// 👍 859 👎 61


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DP T:O(m^2*n^2) S:O(mn)
    // 拆分子问题：以i1，i2为顶点、j1，j2为终点的矩形的和为 sum[j1][j2] = sum[j1-1][j2] + sum[j1][j2-1] - sum[j1-1][j2-1] + m[j1][j2]
    // state array dp[i][j]
    // DP方程 dp[j1][j2] = dp[j1-1][j2] + dp[j1][j2-1] - dp[j1-1][j2-1] + m[j1][j2]
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length, ans = Integer.MIN_VALUE;
        for (int i1 = 1; i1 <= m; i1++) {
            for (int j1 = 1; j1 <= n; j1++) {
                int[][] dp = new int[m + 1][n + 1];
                dp[i1][j1] = matrix[i1 - 1][j1 - 1];
                for (int i2 = i1; i2 <= m; i2++) {
                    for (int j2 = j1; j2 <= n; j2++) {
                        dp[i2][j2] = dp[i2 - 1][j2] + dp[i2][j2 - 1] - dp[i2 - 1][j2 - 1] + matrix[i2 - 1][j2 - 1];
                        if (dp[i2][j2] <= k) ans = Math.max(ans, dp[i2][j2]);
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
