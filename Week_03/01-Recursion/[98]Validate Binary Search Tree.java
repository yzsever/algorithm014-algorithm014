//Given a binary tree, determine if it is a valid binary search tree (BST). 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's
// key. 
// The right subtree of a node contains only nodes with keys greater than the no
//de's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
//
// Example 1: 
//
// 
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
// Related Topics Tree Depth-first Search 
// 👍 4224 👎 558


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

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
    public boolean isValidBST1(TreeNode root) {
        // 1、递归 DFS T:O(n) S:O(n)
        return recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean recursion(TreeNode root, long bottom, long floor){
        // terminator
        if(root == null){
            return true;
        }
        // process current logic
        if(root.val <= bottom || root.val >= floor){
            return false;
        }
        // drill down
        return recursion(root.left, bottom, root.val) && recursion(root.right, root.val, floor);
        // restore current status
    }

    public boolean isValidBST2(TreeNode root) {
        // 2、中序遍历 T:O(n) S:O(n)
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        long num = Long.MIN_VALUE;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.val > num) {
                num = node.val;
            } else {
                return false;
            }
            node = node.right;
        }
        return true;
    }

    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        // 2、中序遍历+递归 T:O(n) S:O(n)
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
