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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode cur = head;
        ListNode p1 = head;
        ListNode p2 = head;
        int length = 0;
            
        while (cur != null) {
            length += 1;
            cur = cur.next;
        }
        int k2 = length - k;
        
        while (k > 1) {
            k -= 1;
            p1 = p1.next;
        }
        
        while (k2 > 0) {
            p2 = p2.next;
            k2 -= 1;
        }
        int temp = p1.val;
        p1.val = p2.val;
        p2.val = temp;
        
        return head;
    }
}
