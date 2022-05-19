class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        
        for (int i = 0; i < k + 1; i ++) {
            int[] tmpPrices = prices.clone();
            for (int[] tmp: flights) {
                int s = tmp[0], d = tmp[1], cost = tmp[2];
                if (prices[s] == Integer.MAX_VALUE) {
                    continue;
                }
                if (prices[s] + cost < tmpPrices[d]) {
                    tmpPrices[d] = prices[s] + cost;
                }
            }
            prices = tmpPrices;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
