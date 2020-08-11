//Given a linked list, determine if it has a cycle in it. 
//
// To represent a cycle in the given linked list, we use an integer pos which re
//presents the position (0-indexed) in the linked list where tail connects to. If 
//pos is -1, then there is no cycle in the linked list. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: head = [3,2,0,-4], pos = 1
//Output: true
//Explanation: There is a cycle in the linked list, where tail connects to the s
//econd node.
// 
// 
//
// 
// 
//
// Example 2: 
//
// 
//Input: head = [1,2], pos = 0
//Output: true
//Explanation: There is a cycle in the linked list, where tail connects to the f
//irst node.
// 
// 
//
// 
// 
//
// Example 3: 
//
// 
//Input: head = [1], pos = -1
//Output: false
//Explanation: There is no cycle in the linked list.
// 
// 
//
// 
//
// 
//
// Follow up: 
//
// Can you solve it using O(1) (i.e. constant) memory? 
// Related Topics Linked List Two Pointers 
// 👍 3056 👎 509


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
//      1、用一个数据结构记录链表的元素，遍历的同时判断是否已经存在，存在则是环形链表 O(n^2)
//      2、快慢指针，快指针每次走2步，慢指针每次走1步，如果有环就一定会相遇 O(n)
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;

//      3、破坏链表的结构，遍历后将当前节点的next指到同一位置(如head)，如果有节点的next为设置的位置，则有环存在 O(n)
/*        ListNode p = head;
        ListNode pre = head;
        while (p != null && p.next != null) {
            if (p.next == head) {
                return true;
            }
            p = p.next;
            pre.next = head;
            pre = p;
        }
        return false;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
