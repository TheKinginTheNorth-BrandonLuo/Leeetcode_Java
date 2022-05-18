class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        board[rMove][cMove] = color;
        for (int[] d: directions) {
            if (isLegal(board, rMove, cMove, color, d)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isLegal(char[][] board, int r, int c, char color, int[] d) {
        int dr = d[0], dc = d[1];
        r += dr;
        c += dc;
        int length = 1;
        
        while (0 <= r && r < board.length && 0 <= c && c < board[0].length) {
            length += 1;
            if (board[r][c] == '.') {
                return false;
            }
            if (board[r][c] == color) {
                return length >= 3;
            }
            r += dr;
            c += dc;
        }
        return false;
    }
}
