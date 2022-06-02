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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            ListNode Next = l1 != null ? l1 : (l2 != null ? l2 : (new ListNode(0)));
            int sum = (l2 == null ? 0 : l2.val) + (l1 == null ? 0 : l1.val) + carry;
            Next.val = sum % 10;
            carry = sum / 10;
            cur.next = Next;
            cur = cur.next;
            
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return dummy.next;
    }
}
