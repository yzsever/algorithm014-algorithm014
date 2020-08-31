//Given the root of a binary tree, return an array of the largest value in each 
//row of the tree (0-indexed). 
//
// 
//
// 
// Example 1: 
//
// 
//Input: root = [1,3,2,5,3,null,9]
//Output: [1,3,9]
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,3]
//Output: [1,3]
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// Example 4: 
//
// 
//Input: root = [1,null,2]
//Output: [1,2]
// 
//
// Example 5: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the tree will be in the range [1, 104]. 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics Tree Depth-first Search Breadth-first Search 
// 👍 966 👎 64
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    // 1 BFS
    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> largestValues = new ArrayList<>();
        if (root == null) {
            return largestValues;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            largestValues.add(max);
        }
        return largestValues;
    }

    // 2 DFS
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestValues = new ArrayList<>();
        levelHelper(root, 0, largestValues);
        return largestValues;
    }

    private void levelHelper(TreeNode root, int height, List<Integer> largestValues){
        if(root == null){
            return;
        }
        if(height >= largestValues.size()){
            largestValues.add(Integer.MIN_VALUE);
        }
        largestValues.set(height, Math.max(largestValues.get(height), root.val));
        levelHelper(root.left, height+1, largestValues);
        levelHelper(root.right, height+1, largestValues);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
