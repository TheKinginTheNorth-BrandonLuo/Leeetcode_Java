class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int ROWS = obstacleGrid.length, COLS = obstacleGrid[0].length;
        int[][] dp = new int[ROWS][COLS];
        
        for (int[] row: dp) {
            Arrays.fill(row, 0);
        }
        
        for (int c = 0; c < COLS; c ++) {
            if (obstacleGrid[0][c] == 1) {
                break;
            }
            dp[0][c] = 1;
        }
        
        for (int r = 0; r < ROWS; r ++) {
            if (obstacleGrid[r][0] == 1) {
                break;
            }
            dp[r][0] = 1;
        }
        
        for (int r = 1; r < ROWS; r ++) {
            for (int c = 1; c < COLS; c ++) {
                if (obstacleGrid[r][c] == 1) {
                    continue;
                }
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[ROWS - 1][COLS - 1];
    }
}
