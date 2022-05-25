class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || k == 0) {
            return 0;
        }
        
        int[] buy = new int[k];
        int[] profits = new int[k];
        
        Arrays.fill(buy, Integer.MAX_VALUE);
        Arrays.fill(profits, 0);
        
        for (int p: prices) {
            buy[0] = Math.min(buy[0], p);
            profits[0] = Math.max(profits[0], p - buy[0]);
            
            for (int i = 1; i < k; i ++) {
                buy[i] = Math.min(buy[i], p - profits[i - 1]);
                profits[i] = Math.max(profits[i], p - buy[i]);
            }
        }
        return profits[k - 1];
    }
}
