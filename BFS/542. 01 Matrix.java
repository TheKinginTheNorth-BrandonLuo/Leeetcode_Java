class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] res = new int[mat.length][mat[0].length];
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] row: res) {
            Arrays.fill(row, -1);
        }
        
        for (int r = 0; r < mat.length; r ++) {
            for (int c = 0; c < mat[0].length; c ++) {
                if (mat[r][c] == 0) {
                    res[r][c] = 0;
                    queue.offer(new int[]{r, c});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            for (int[] dir: directions) {
                int newRow = tmp[0] + dir[0], newCol = tmp[1] + dir[1];
                if (0 <= newRow && 0 <= newCol && newRow < mat.length && newCol < mat[0].length && res[newRow][newCol] == -1) {
                    res[newRow][newCol] = res[tmp[0]][tmp[1]] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        return res;
    }
}
