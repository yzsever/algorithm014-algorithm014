//Given a linked list, reverse the nodes of a linked list k at a time and return
// its modified list. 
//
// k is a positive integer and is less than or equal to the length of the linked
// list. If the number of nodes is not a multiple of k then left-out nodes in the 
//end should remain as it is. 
//
// 
// 
//
// Example: 
//
// Given this linked list: 1->2->3->4->5 
//
// For k = 2, you should return: 2->1->4->3->5 
//
// For k = 3, you should return: 3->2->1->4->5 
//
// Note: 
//
// 
// Only constant extra memory is allowed. 
// You may not alter the values in the list's nodes, only nodes itself may be ch
//anged. 
// 
// Related Topics Linked List 
// 👍 2392 👎 361


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
    public ListNode reverseKGroup(ListNode head, int k) {
//        1、递归法，找到k+1个节点后，调用递归，再把当前的k个节点一个个放在排序好的k个节点的头部
/*        if (head == null || k <= 1) {
            return head;
        }
        ListNode p = head;
        int count = 0;
        // 找到k+1个节点后
        while (count < k) {
            if (p == null) {
                return head;
            }
            p = p.next;
            count++;
        }
        // 调用递归
        ListNode prev = reverseKGroup(p, k);
        // 把当前的k个节点一个个放在排序好的k个节点的头部
        while (count-- > 0) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;*/

//        2、迭代法，每遍历k个节点执行一次反转。创建一个虚拟节点放在head前面，统一反转的操作
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode node = head;
        ListNode begin = dummyNode;
        int i = 1;
        while (node != null) {
            if (i++ % k == 0) {
                begin = reverse(begin, node.next);
                node = begin.next;
            } else {
                node = node.next;
            }
        }
        return dummyNode.next;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode first = begin.next;
        ListNode node = begin.next;
        ListNode newHead = begin;
        ListNode next;
        // 将node不停的作为新的头节点
        while (node != end) {
            next = node.next;
            node.next = newHead;
            newHead = node;
            node = next;
        }
        begin.next = newHead;
        first.next = end;
        return first;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
