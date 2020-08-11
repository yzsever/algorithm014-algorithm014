//Reverse a singly linked list. 
//
// Example: 
//
// 
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
// 
//
// Follow up: 
//
// A linked list can be reversed either iteratively or recursively. Could you im
//plement both? 
// Related Topics Linked List 
// 👍 4781 👎 91


//leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode reverseList(ListNode head) {
//      1、最近重复子问题，就是元素不断放在目标队列的前面
/*        if(head == null || head.next == null){
            return head;
        }
        ListNode q = head.next;
        head.next = null;
        while (q != null) {
            ListNode next = q.next;
            q.next = head;
            head = q;
            q = next;
        }
        return head;*/

        //2、高票迭代法
/*        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;*/

        //3、高票递归法
        // 将当前节点后面的链表反转后，再将当前节点放在新链的后面
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
