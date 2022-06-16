class Solution {
    public int numSquares(int n) {
        if (n < 3) {
            return n;
        }
        
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i ++) {
            dp[i] = i;
        }
        
        int end = (int)Math.pow(n, 0.5);
        
        for (int i = 2; i < end + 1; i ++) {
            int s = i * i;
            for (int j = s; j < n + 1; j ++) {
                dp[j] = Math.min(dp[j], dp[j - s] + 1);
            }
        }
        return dp[n];
    }
}
