//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics String Backtracking 
// 👍 6311 👎 292


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DFS
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        dfs(n, 0, 0, "", results);
        return results;
    }

    private void dfs(int n, int open, int close, String s, List<String> results) {
        // terminator
        if (open + close == 2 * n) {
            results.add(s);
            return;
        }
        // process current logic
        // pruning
        if (open < n) {
            // drill down
            dfs(n, open + 1, close, s + '(', results);
        }
        if (close < open) {
            // drill down
            dfs(n, open, close + 1, s + ')', results);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
