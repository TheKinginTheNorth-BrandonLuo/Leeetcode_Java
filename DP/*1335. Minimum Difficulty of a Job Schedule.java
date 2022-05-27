class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
       int n =  jobDifficulty.length;
        if (d > n) {
            return -1;
        }
        int[][] dp = new int[d + 1][n + 1];
        for (int i = 1; i < n + 1; i ++) {
            dp[1][i] = Math.max(dp[1][i - 1], jobDifficulty[i - 1]);
        }
        
        for (int i = 2; i < d + 1; i ++) {
            for (int j = i; j < n + 1; j ++) {
                dp[i][j] = Integer.MAX_VALUE;
                int curMax = 0;
                for (int k = j; k >= i; k --) {
                    curMax = Math.max(curMax, jobDifficulty[k - 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k - 1] + curMax);
                }
            }
        }
        return dp[d][n];
    }
}
