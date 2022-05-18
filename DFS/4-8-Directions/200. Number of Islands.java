class Solution {
    public int numIslands(char[][] grid) {
        int isLands = 0;
        for (int r = 0; r < grid.length; r ++) {
            for (int c = 0; c < grid[0].length; c ++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    isLands += 1;
                }
            }
        }
        return isLands;
    }
    
    public void dfs(char[][] grid, int r, int c) {
        grid[r][c] = '0';
        int[][] directions = {{r - 1, c}, {r + 1, c}, {r, c + 1}, {r, c - 1}};
        for (int[] dir: directions) {
            if (dir[0] >= 0 && dir[1] >= 0 && dir[0] < grid.length && dir[1] < grid[0].length && grid[dir[0]][dir[1]] == '1') {
                dfs(grid, dir[0], dir[1]);
            }
        }
    }
}
