class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        
        for (int r = 0; r < heights.length; r ++) {
            dfs(heights, r, 0, pacific);
            dfs(heights, r, heights[0].length - 1, atlantic);
        }
        
        for (int c = 0; c < heights[0].length; c ++) {
            dfs(heights, 0, c, pacific);
            dfs(heights, heights.length - 1, c,  atlantic);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < heights.length; r ++) {
            for (int c = 0; c < heights[0].length; c ++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(r);
                    tmp.add(c);
                    res.add(tmp);
                }
            }
        }
        return res;
        
    }
    
    private void dfs(int[][] heights, int r, int c, boolean[][] visited) {
        if (visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        int[][] directions = {{r - 1, c}, {r + 1, c}, {r, c + 1}, {r, c - 1}};
        for (int[] dir: directions) {
            if (dir[0] >= 0 && dir[1] >= 0 && dir[0] < heights.length && dir[1] < heights[0].length && heights[dir[0]][dir[1]] >= heights[r][c]) {
                dfs(heights, dir[0], dir[1], visited);
            }
        }
    }
}
