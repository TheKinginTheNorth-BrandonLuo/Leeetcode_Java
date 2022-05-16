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
    public void reorderList(ListNode head) {
        if (head != null && head.next != null && head.next.next != null) {
            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode left = head, right = slow.next;
            slow.next = null;
            
            // reverse right part linkedList
            ListNode dummy = new ListNode(0);
            dummy.next = right;
            ListNode p = right.next;
            right.next = null;
            while (p != null) {
                ListNode tmp = p;
                p = p.next;
                tmp.next = dummy.next;
                dummy.next = tmp;
            }
            right = dummy.next;
            
            ListNode p1 = left, p2 = right;
            while (p2 != null) {
                ListNode tmp1 = p1.next;
                ListNode tmp2 = p2.next;
                p1.next = p2;
                p2.next = tmp1;
                p1 = tmp1;
                p2 = tmp2;
            }
        }
    }
}
