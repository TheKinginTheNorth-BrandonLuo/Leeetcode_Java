class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int ROWS = matrix.length, COLS = matrix[0].length;
        int[][] dp = new int[ROWS][COLS];
        for (int[] row: dp) {
            Arrays.fill(row, 0);
        }
        
        for (int r = 0; r < ROWS; r ++) {
            dp[r][0] = matrix[r][0] == '1' ? 1 : 0;
        }
        
        for (int c = 0; c < COLS; c ++) {
            dp[0][c] = matrix[0][c] == '1' ? 1 : 0;
        }
        for (int r = 1; r < ROWS; r ++) {
            for (int c = 1; c < COLS; c ++) {
                if (matrix[r][c] == '1') {
                    dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]) + 1;
                }
            }
        }
        int max = 0;
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                max = Math.max(max, dp[r][c]);
            }
        }
        return max * max;
    }
}
