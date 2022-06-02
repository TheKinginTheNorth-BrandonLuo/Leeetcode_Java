class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int[][] dp = new int[ROWS][COLS];
        boolean[][] visited = new boolean[ROWS][COLS];
        for (int[] row: dp) {
            Arrays.fill(row, 0);
        }
        
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                dfs(matrix, r, c, -1, dp, visited);
            }
        }
        
        int max = 0;
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                max = Math.max(max, dp[r][c]);
            }
        }
        return max;
        
    }
    
    private int dfs(int[][] matrix, int r, int c, int prev, int[][] dp, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || matrix[r][c] <= prev) {
            return 0;
        }
        if (visited[r][c]) {
            return dp[r][c];
        }
        
        int path = 1;
        path = Math.max(path, 1 + dfs(matrix, r - 1, c, matrix[r][c], dp, visited));
        path = Math.max(path, 1 + dfs(matrix, r + 1, c, matrix[r][c], dp, visited));
        path = Math.max(path, 1 + dfs(matrix, r, c - 1, matrix[r][c], dp, visited));
        path = Math.max(path, 1 + dfs(matrix, r, c + 1, matrix[r][c], dp, visited));
        
        dp[r][c] = path;
        visited[r][c] = true;
        return path;
        
    }
}
