class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        
        ListNode oddCur = head, cur = head, evenCur = head.next, evenHead = head.next;
        int i = 1;
        
        while (cur != null) {
            if (i > 2 && i % 2 != 0) {
                oddCur.next = cur;
                oddCur = oddCur.next;
            } else if (i > 2 && i % 2 == 0){
                evenCur.next = cur;
                evenCur = evenCur.next;
            }
            cur = cur.next;
            i += 1;
        }
        
        oddCur.next = evenHead;
        evenCur.next = null;
        
        return head;
        
    }
}
