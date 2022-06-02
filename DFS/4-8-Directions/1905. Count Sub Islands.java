class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ROWS = grid1.length, COLS = grid1[0].length;
        
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (grid1[r][c] == 0 && grid2[r][c] == 1) {
                    dfs(grid2, r ,c);
                }
            }
        }
        
        int count = 0;
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (grid2[r][c] == 1) {
                    dfs(grid2, r, c);
                    count += 1;
                }
            }
        }
        return count;
    }
    
    private void dfs(int[][] grid2, int r, int c) {
        if (r < 0 || c < 0 || r >= grid2.length || c >= grid2[0].length || grid2[r][c] == 0) {
            return ;
        }
        grid2[r][c] = 0;
        dfs(grid2, r - 1, c);
        dfs(grid2, r + 1, c);
        dfs(grid2, r, c - 1);
        dfs(grid2, r, c + 1);
        
    }
}
