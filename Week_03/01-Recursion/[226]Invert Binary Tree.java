//Invert a binary tree. 
//
// Example: 
//
// Input: 
//
// 
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// Output: 
//
// 
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// Trivia: 
//This problem was inspired by this original tweet by Max Howell: 
//
// Google: 90% of our engineers use the software you wrote (Homebrew), but you c
//an’t invert a binary tree on a whiteboard so f*** off. 
// Related Topics Tree 
// 👍 3625 👎 59

import java.util.LinkedList;
import java.util.Queue;
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
    // 1、递归+DFS T:O(n) S:O(n)
/*
    public TreeNode invertTree(TreeNode root) {
        // terminator
        if(root == null){
            return root;
        }

        // process current logic
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        // drill down
        invertTree(root.left);
        invertTree(root.right);

        // restore current status
        return root;
    }
*/

    // 2、BFS T:O(n) S:O(n)
    public TreeNode invertTree(TreeNode root) {
        // terminator
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode leftNode = node.left;
                node.left = node.right;
                node.right = leftNode;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
