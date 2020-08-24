//Given preorder and inorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics Array Tree Depth-first Search 
// 👍 3688 👎 100


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
    // 1、递归 T:O(n) S:O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursion(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode recursion(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        // terminator
        if (preStart >= preorder.length || inStart > inEnd) {
            return null;
        }
        // process current logic
        TreeNode root = new TreeNode(preorder[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                // drill down
                root.left = recursion(preorder, preStart + 1, inorder, inStart, i - 1);
                // i-inStart is left tree's size
                root.right = recursion(preorder, preStart + i - inStart + 1, inorder, i + 1, inEnd);
                break;
            }
        }
        // restore current status

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
