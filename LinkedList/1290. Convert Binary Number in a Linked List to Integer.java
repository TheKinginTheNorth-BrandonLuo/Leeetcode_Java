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
    public int getDecimalValue(ListNode head) {
//         Loop	Character	Operation	  Result
// 1	    ‘1’	        1	          1
// 2	    ‘0’	        (1x2) + 0	  2
// 3	    ‘1’	        (2*2) + 1	  5
        int sum = 0;
        while (head != null) {
            sum *= 2;
            sum += head.val;
            head = head.next;
        }
        return sum;
    }
}
