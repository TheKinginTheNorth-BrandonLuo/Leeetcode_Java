class Solution {
    public int pairSum(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode cur = head;
        
        while (cur != null) {
            res.add(cur.val);
            cur = cur.next;
        }
        
        int max = 0;
        for (int i = 0; i < res.size(); i ++) {
            max = Math.max(max, res.get(i) + res.get(res.size() - i - 1));
        }
        
        return max;
    }
}
