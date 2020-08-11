//Given a linked list, return the node where the cycle begins. If there is no cy
//cle, return null. 
//
// To represent a cycle in the given linked list, we use an integer pos which re
//presents the position (0-indexed) in the linked list where tail connects to. If 
//pos is -1, then there is no cycle in the linked list. 
//
// Note: Do not modify the linked list. 
//
// 
//
// Example 1: 
//
// 
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the s
//econd node.
// 
//
// 
//
// Example 2: 
//
// 
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the f
//irst node.
// 
//
// 
//
// Example 3: 
//
// 
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.
// 
//
// 
//
// 
//
// Follow-up: 
//Can you solve it without using extra space? 
// Related Topics Linked List Two Pointers 
// 👍 2868 👎 227


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
    public ListNode detectCycle(ListNode head) {
/*
        1、快慢指针，快指针每次走2步，慢指针每次走1步，如果有环就一定会相遇。相遇后，新指针从链头和慢指针一直走，相遇点为环头位置
        找环头数学证明：
        设C为环的长度，H为链头到环头的距离，K为快慢指针相遇节点与环头的距离
        D(快)=H+C*x+K x为快指针相遇前完成了环数
        D(慢)=H+C*y+K y为慢指针相遇前完成了环数
        x>y
        因为快指针速度时慢指针的两倍
        所以D(快)=2D(慢)
        H+K=(x-2y)*C
        所以H+K的距离为多次循环
        H=n*C-K
        当前慢指针在C的位置，一个New指针从头开始走H步时，慢指针走了n*C-K步，正好走到环头和New指针相遇
        */
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                while(slow != head){
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
