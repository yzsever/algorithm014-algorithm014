//Given a binary tree, return the preorder traversal of its nodes' values. 
//
// Example: 
//
// 
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,2,3]
// 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics Stack Tree 
// 👍 1641 👎 61

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
    public List<Integer> preorderTraversal(TreeNode root) {
//        1、使用递归遍历。根-左-右 T:O(n) S:O(n)
/*        List<Integer> traversalPath = new ArrayList<>();
        helper(root, traversalPath);
        return traversalPath;*/

//        2、迭代法使用栈。T:O(n) S:O(n)
//        - 当node不等于null或者stack不为空的时候执行遍历
//        - 将node元素先读取值
//        - 然后将node的右节点入栈
//        - 遍历左节点
//        - 如果node为空则推出栈中节点为node
        List<Integer> traversalPath = new ArrayList<>();
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node == null) {
                node = stack.pop();
            }
            traversalPath.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            node = node.left;
        }
        return traversalPath;
    }

    private void helper(TreeNode root, List<Integer> traversalPath) {
        if (root != null) {
            traversalPath.add(root.val);
            helper(root.left, traversalPath);
            helper(root.right, traversalPath);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
