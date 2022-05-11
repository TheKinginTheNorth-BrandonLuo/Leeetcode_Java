lass Solution {
    public int islandPerimeter(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int res = 0;
        
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (grid[r][c] == 1) {
                    res += 4;
                    if (r > 0 && grid[r - 1][c] == 1) {
                        res -= 2;
                    }
                    if (c > 0 && grid[r][c - 1] == 1) {
                        res -= 2;
                    }
                }
            }
        }
        return res;
    }
}
