//Given a binary tree, return the level order traversal of its nodes' values. (i
//e, from left to right, level by level). 
//
// 
//For example: 
//Given binary tree [3,9,20,null,null,15,7], 
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// 
// 
//return its level order traversal as: 
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics Tree Breadth-first Search 
// 👍 3309 👎 78
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
    // 1、BFS+队列 T:O(n) S:O(n)
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> result = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                result.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            results.add(result);
        }
        return results;
    }

    // 2、DFS+递归
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        levelHelper(results, root, 0);
        return results;
    }

    private void levelHelper(List<List<Integer>> results, TreeNode root, int high) {
        if(root == null){
            return;
        }
        if(high >= results.size()){
            results.add(new ArrayList<Integer>());
        }
        results.get(high).add(root.val);
        levelHelper(results, root.left, high+1);
        levelHelper(results, root.right, high+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
