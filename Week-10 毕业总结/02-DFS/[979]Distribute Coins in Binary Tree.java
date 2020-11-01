//Given the root of a binary tree with N nodes, each node in the tree has node.v
//al coins, and there are N coins total. 
//
// In one move, we may choose two adjacent nodes and move one coin from one node
// to another. (The move may be from parent to child, or from child to parent.) 
//
// Return the number of moves required to make every node have exactly one coin.
// 
//
// 
//
// 
// Example 1: 
//
// 
//
// 
//Input: [3,0,0]
//Output: 2
//Explanation: From the root of the tree, we move one coin to its left child, an
//d one coin to its right child.
// 
//
// 
// Example 2: 
//
// 
//
// 
//Input: [0,3,0]
//Output: 3
//Explanation: From the left child of the root, we move two coins to the root [t
//aking two moves].  Then, we move one coin from the root of the tree to the right
// child.
// 
//
// 
// Example 3: 
//
// 
//
// 
//Input: [1,0,2]
//Output: 2
// 
//
// 
// Example 4: 
//
// 
//
// 
//Input: [1,0,0,null,3]
//Output: 4
// 
//
// 
//
// Note: 
//
// 
// 1<= N <= 100 
// 0 <= node.val <= N 
// 
// 
// 
// 
// Related Topics Tree Depth-first Search 
// 👍 1895 👎 69


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
    // DFS
    // 参考https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/917306/C%2B%2B-Easy-Explained
    // the idea is that of dfs only, int dfs function, the node will try to satisfy coins needed to receive/send by any
    // of its parent node, and then will return the coins needed to send/receive by itself to the parent

    // we count moves as when a req for send/receive coind is
    // generated, if it is settled by parent node, then it is not
    // recalculated, otherwise it gets added again and again till
    // it is fulfilled
    int ans = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        // terminator
        if (root == null) return 0;
        // process current logic
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
