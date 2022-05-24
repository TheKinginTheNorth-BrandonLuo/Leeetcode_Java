class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0, minute = 0;
        int ROWS = grid.length, COLS = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (grid[r][c] == 1) {
                    fresh += 1;
                }
                else if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
            }
        }
        
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                int[] temp = queue.poll();
                int r = temp[0];
                int c = temp[1];
                int[][] directions = {{r - 1, c}, {r + 1, c}, {r, c + 1}, {r, c - 1}};
                for (int[] dir: directions) {
                    if (dir[0] < 0 || dir[1] < 0 || dir[0] >= ROWS || dir[1] >= COLS || grid[dir[0]][dir[1]] != 1) {
                        continue;
                    }
                    grid[dir[0]][dir[1]] = 2;
                    queue.offer(new int[]{dir[0], dir[1]});
                    fresh -= 1;
                }
            }
            minute += 1;
        }
        return fresh == 0 ? minute : -1;
    }
}
