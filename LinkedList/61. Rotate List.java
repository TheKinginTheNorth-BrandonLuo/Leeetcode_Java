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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        
        int length = 1;
        while (head.next != null) {
            head = head.next;
            length += 1;
        }
        
        head.next = tail;
        head = head.next;
        
        for (int i = 0; i < length - k % length - 1; i ++) {
            head = head.next;
        }
        
        ListNode res = head.next;
        head.next = null;
        
        return res;
    }
}
