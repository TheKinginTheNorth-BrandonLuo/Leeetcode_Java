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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        Stack<Integer> stack = new Stack<>();
        
        while (fast != null && fast.next != null) {
            stack.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast != null) { // length is odd
            slow = slow.next;
        }
        
        while (slow != null) {
            int p = stack.pop();
            if (slow.val != p) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
