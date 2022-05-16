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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode node = head;
        
        while (node != null) {
            ListNode cur = node;
            node = node.next;
            if (cur.val < pre.val) {
                pre = dummy;
            }
            while (pre.next != null && cur.val > pre.next.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
        }
        return dummy.next;
    }
}
