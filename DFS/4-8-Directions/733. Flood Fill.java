class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            dfs(image, sr, sc, newColor, oldColor);
        }
        return image;
    }
    
    private void dfs(int[][] image, int r, int c, int newColor, int oldColor) {
        image[r][c] = newColor;
        int[][] directions = {{r - 1, c}, {r + 1, c}, {r, c + 1}, {r, c - 1}};
        for (int[] dir: directions) {
            if (0 <= dir[0] && 0 <= dir[1] && dir[0] < image.length && dir[1] < image[0].length && image[dir[0]][dir[1]] == oldColor) {
                dfs(image, dir[0], dir[1], newColor, oldColor);
            }
        }
    }
}
