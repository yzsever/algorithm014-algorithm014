//Given two integers n and k, return all possible combinations of k numbers out 
//of 1 ... n. 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
//
// Example 2: 
//
// 
//Input: n = 1, k = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics Backtracking 
// 👍 1592 👎 68


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1、回溯算法+剪枝
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n == 0 || k == 0 || n < k){
            return ans;
        }
        backtracking(n, k, 1, new Stack<Integer>());
        return ans;
    }

    private void backtracking(int n, int k, int start, Stack<Integer> track) {
        // terminator
        if (track.size() == k) {
            ans.add(new ArrayList<>(track));
            return;
        }
        // process current logic
        for (int i = start; i <= n - (k - track.size()) + 1; i++) {
            track.push(i);
            // drill down
            backtracking(n, k, i + 1, track);
            // restore current status
            track.pop();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
