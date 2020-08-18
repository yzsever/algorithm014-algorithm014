//Given an n-ary tree, return the postorder traversal of its nodes' values. 
//
// Nary-Tree input serialization is represented in their level order traversal, 
//each group of children is separated by the null value (See examples). 
//
// 
//
// Follow up: 
//
// Recursive solution is trivial, could you do it iteratively? 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,null,3,2,4,null,5,6]
//Output: [5,6,3,2,4,1]
// 
//
// Example 2: 
//
// 
//
// 
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null
//,12,null,13,null,null,14]
//Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
// 
//
// 
// Constraints: 
//
// 
// The height of the n-ary tree is less than or equal to 1000 
// The total number of nodes is between [0, 10^4] 
// 
// Related Topics Tree 
// 👍 698 👎 64

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/



class Solution {
    public List<Integer> postorder(Node root) {
        //1、使用递归遍历，左-右-根 T:O(n) S:O(n)
/*        List<Integer> travseralPath = new ArrayList<>();
        helper(root, travseralPath);
        return travseralPath;*/

        //2、迭代法使用栈 T:O(n) S:O(n)
        //- 将元素压栈
        //- 再将元素出栈，同时将所有的子入栈
        List<Integer> travseralPath = new ArrayList<>();
        if(root == null){
            return travseralPath;
        }
        Stack<Node> stack = new Stack<>();
        Node node;
        stack.push(root);
        while (!stack.isEmpty()) {
            node = stack.pop();
            travseralPath.add(node.val);
            if(node.children != null){
                for(Node children : node.children){
                    stack.push(children);
                }
            }
        }
        Collections.reverse(travseralPath);
        return travseralPath;
    }

    private void helper(Node root, List<Integer> travseralPath) {
        if (root != null) {
            if (root.children != null) {
                for (Node children : root.children) {
                    helper(children, travseralPath);
                }
            }
            travseralPath.add(root.val);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
