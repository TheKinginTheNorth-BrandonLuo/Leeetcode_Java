class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length, COLS = board[0].length;
        // 1. convert boarder to 'T'
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (board[r][c] == 'O' && ((r == 0 || r == ROWS - 1) || (c == 0 || c == COLS - 1))) {
                    capture(board, r, c);
                }
            }
        }
        
        // 2. convert non-boarder 'O' to 'X'
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
        
        // 3. convert boarder 'T' to 'O'
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
        
    }
    
    public void capture(char[][] board, int r, int c) {
        if (r >= 0  && c >= 0 && r < board.length && c < board[0].length && board[r][c] == 'O') {
            board[r][c] = 'T';
            int[][] directions = {{r - 1, c}, {r + 1, c}, {r, c + 1}, {r, c - 1}};
            for (int[] dir: directions) {
                capture(board, dir[0], dir[1]);
            }
        }
    }
}
