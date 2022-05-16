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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head, slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }
    
    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                pre.next = h1;
                pre = h1;
                h1 = h1.next;
            } else {
                pre.next = h2;
                pre = h2;
                h2 = h2.next;
            }
        }
        if (h1 != null) {
            pre.next = h1;
        } else if (h2 != null) {
            pre.next = h2;
        }
        return dummy.next;
    }
}
