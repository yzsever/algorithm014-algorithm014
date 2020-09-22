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
// 👍 5932 👎 293


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // T:O(2^n) S:O(n^2)
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        dfs(n, "", 0, 0, results);
        return results;
    }

    private void dfs(int n, String s, int open, int close, List<String> results) {
        if (open + close == 2 * n) {
            results.add(s);
            return;
        }
        if (open < n) dfs(n, s + "(", open + 1, close, results);
        if (close < open) dfs(n, s + ")", open, close + 1, results);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
