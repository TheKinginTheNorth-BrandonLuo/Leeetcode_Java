class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 & n == 1) {
            return 1;
        }
        
        int[][] dp = new int[m][n];
        for (int[] row: dp) {
            Arrays.fill(row, 1);
        }
        
        for (int r = 1; r < m; r ++) {
            for (int c = 1; c < n; c ++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
