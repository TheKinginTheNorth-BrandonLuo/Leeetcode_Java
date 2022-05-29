class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0] == null) {
            return 0;
        }
        int ROWS = grid.length, COLS = grid[0].length, prevSum;
        
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (r == 0 && c == 0) {
                    prevSum = 0;
                }
                else if (r == 0) {
                    prevSum = grid[r][c - 1];
                }
                else if (c == 0) {
                    prevSum = grid[r - 1][c];
                }
                else {
                    prevSum = Math.min(grid[r - 1][c], grid[r][c - 1]);
                }
                grid[r][c] = prevSum + grid[r][c];
            }
        }
        return grid[ROWS - 1][COLS - 1];
    }
}
