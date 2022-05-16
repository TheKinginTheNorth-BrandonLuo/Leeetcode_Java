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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        for (int i = 0; i < a - 1; i ++) {
            head = head.next;
        }
        
        ListNode cur = head.next;
        for (int i = 0; i < b - a; i ++) {
            cur = cur.next;
        }
        head.next = list2;
        while (head.next != null) {
            head = head.next;
        }
        if (cur.next != null) {
            head.next = cur.next;
        }
        return list1;
    }
}
