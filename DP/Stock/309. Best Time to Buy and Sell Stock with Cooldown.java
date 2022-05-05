class Solution {
    public int maxProfit(int[] prices) {
//         hold -----do nothing----->hold

//         hold -----sell----->notHold_cooldown

//         notHold -----do nothing -----> notHold

//         notHold -----buy-----> hold

//         notHold_cooldown -----do nothing----->notHold
        int hold = Integer.MIN_VALUE, notHold = 0, notHoldCoolDown = Integer.MIN_VALUE;
        
        for (int p: prices) {
            int tmp_hold = hold;
            hold = Math.max(hold, notHold - p);
            notHold = Math.max(notHold, notHoldCoolDown);
            notHoldCoolDown = tmp_hold + p;
        }
        return Math.max(notHold, notHoldCoolDown);
    }
}
