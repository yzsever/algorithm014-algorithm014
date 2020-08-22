//Given a binary tree, determine if it is height-balanced. 
//
// For this problem, a height-balanced binary tree is defined as: 
//
// 
// a binary tree in which the left and right subtrees of every node differ in he
//ight by no more than 1. 
// 
//
// 
//
// Example 1: 
//
// Given the following tree [3,9,20,null,null,15,7]: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// Return true. 
// 
//Example 2: 
//
// Given the following tree [1,2,2,3,3,null,null,4,4]: 
//
// 
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// Return false. 
// Related Topics Tree Depth-first Search 
// 👍 2441 👎 179


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
    public boolean isBalanced1(TreeNode root) {
        // 1、自顶向下递归 T:O(n^2) S:O(n)
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        // 2、自底向上递归 T:O(n) S:O(n)
        // 先判断左右子树是不是平衡二叉树，如果是，则返回高度。如果不是，则返回-1；
        return height2(root) >= 0;
    }

    public int height2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height2(node.left);
        int rightHeight = height2(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
