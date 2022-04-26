class Solution {
    public int maxProfit(int[] prices) {
        int one_buy = Integer.MAX_VALUE, two_buy = Integer.MAX_VALUE, one_profit = 0, two_profit = 0;
        
        for (int p: prices) {
            one_buy = Math.min(one_buy, p);
            one_profit = Math.max(one_profit, p - one_buy);
            two_buy = Math.min(two_buy, p - one_profit);
            two_profit = Math.max(two_profit, p - two_buy);
        }
        
        return two_profit;
    }
}
