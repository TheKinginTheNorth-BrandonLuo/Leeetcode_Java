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
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode temp = pre.next;
        int len = 1;
        
        while (temp.next != null) {
            len += 1;
            temp = temp.next;
        }
        
        while (len >= k) {
            ListNode cur = pre.next;
            
            for (int i = 0; i < k - 1; i ++) {
                ListNode t = cur.next;
                cur.next = t.next;
                t.next = pre.next;
                pre.next = t;
            }
            pre = cur;
            len -= k;
        }
        return dummy.next;
    }
}
