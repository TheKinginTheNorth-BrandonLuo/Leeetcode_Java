class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long topSum = 0;
        for (int i: grid[0]) {
            topSum += i;
        }
        long bottomSum = 0;
        long res = Long.MAX_VALUE;
        
        for (int i = 0; i < n; i ++) {
            topSum -= grid[0][i];
            res = Math.min(res, Math.max(topSum, bottomSum));
            bottomSum += grid[1][i];
        }
        return res;
    }
}
