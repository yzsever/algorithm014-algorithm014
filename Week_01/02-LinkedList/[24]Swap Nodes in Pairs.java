//Given a linked list, swap every two adjacent nodes and return its head. 
//
// You may not modify the values in the list's nodes, only nodes itself may be c
//hanged. 
//
// 
//
// Example: 
//
// 
//Given 1->2->3->4, you should return the list as 2->1->4->3.
// 
// Related Topics Linked List 
// 👍 2421 👎 174


//leetcode submit region begin(Prohibit modification and deletion)

import com.magima.checkpoint.service.impl.CheckPointServiceImpl;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // 递归法
        // 思想和反转链表类似，只是原来是一个一个迭代，这里是两个节点一次迭代
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next = head;
        return newHead;

        // 迭代法
/*        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode next, third;
        ListNode prev = new ListNode(-1);
        while (head != null && head.next != null) {
            next = head.next;
            third = next.next;
            // swap
            prev.next = next;
            next.next = head;
            head.next = third;
            prev = head;
            head = third;
        }
        return newHead;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
