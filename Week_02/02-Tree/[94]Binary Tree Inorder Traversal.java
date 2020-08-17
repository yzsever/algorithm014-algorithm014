//Given a binary tree, return the inorder traversal of its nodes' values. 
//
// Example: 
//
// 
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,3,2] 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics Hash Table Stack Tree 
// 👍 3377 👎 140
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> inorderTraversal(TreeNode root) {
//      1、使用递归遍历，左-根-右 T:O(n) S:(n)
/*        List<Integer> traversalPath = new ArrayList<>();
        helper(root, traversalPath);
        return traversalPath;*/

//      2、迭代法使用栈, 如果left不是null，则入栈。否则出栈遍历 T:O(n) S:(n)
        List<Integer> traversalPath = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            // left is not null, push in stack
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            traversalPath.add(node.val);
            node = node.right;
        }
        return traversalPath;
    }

    private void helper(TreeNode root, List<Integer> traversalPath) {
        if (root != null) {
            helper(root.left, traversalPath);
            traversalPath.add(root.val);
            helper(root.right, traversalPath);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
