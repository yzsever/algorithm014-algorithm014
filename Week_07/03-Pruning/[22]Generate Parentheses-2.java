//
//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
// 
//
// 
//For example, given n = 3, a solution set is:
// 
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics String Backtracking 
// 👍 6007 👎 292


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        dfs(n, new StringBuilder(), 0, 0, results);
        return results;
    }

    private void dfs(int n, StringBuilder sb, int open, int close, List<String> results) {
        // terminator
        if (open + close == 2 * n) {
            results.add(sb.toString());
            return;
        }
        // process current logic
        if (open < n) {
            sb.append("(");
            // drill down
            dfs(n, sb, open + 1, close, results);
            sb.setLength(sb.length()-1);
        }
        if (close < open) {
            sb.append(")");
            dfs(n, sb, open, close + 1, results);
            sb.setLength(sb.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
