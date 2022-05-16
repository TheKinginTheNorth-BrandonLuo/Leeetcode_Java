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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        
        int length = 1;
        
        while (head.next != null) {
            head = head.next;
            length += 1;
        }
        
        for (int i = 0; i < length - n; i ++) {
            cur = cur.next;
        }
        
        cur.next = cur.next.next;
        
        return dummy.next;
    }
}
