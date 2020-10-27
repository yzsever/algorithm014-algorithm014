//Given a binary tree and a sum, find all root-to-leaf paths where each path's s
//um equals the given sum. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given the below binary tree and sum = 22, 
//
// 
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \    / \
//7    2  5   1
// 
//
// Return: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics Tree Depth-first Search 
// 👍 2196 👎 77
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        backtracking(root, sum, new ArrayList<>(), results);
        return results;
    }

    private void backtracking(TreeNode root, int sum, List<Integer> result, List<List<Integer>> results) {
        // terminator
        if (root == null) return;
        // process current logic
        result.add(root.val);
        if (root.left == null && root.right == null && sum - root.val == 0) {
            results.add(new ArrayList<>(result));
            // restore current state
            result.remove(result.size() - 1);
            return;
        } else {
            // drill down
            backtracking(root.left, sum - root.val, result, results);
            backtracking(root.right, sum - root.val, result, results);
        }
        // restore current state
        result.remove(result.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
