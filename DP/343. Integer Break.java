class Solution {
    public int integerBreak(int n) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        dp.add(1);
        
        for (int i = 2; i < n + 1; i ++) {
            int r = i - 1, l = 1, maxProduct = 0;
            while (l <= r) {
                maxProduct = Math.max(maxProduct, Math.max(l, dp.get(l)) * Math.max(r, dp.get(r)));
                r -= 1;
                l += 1;
            }
            dp.add(maxProduct);
        }
        return dp.get(dp.size() - 1); 
    }
}
