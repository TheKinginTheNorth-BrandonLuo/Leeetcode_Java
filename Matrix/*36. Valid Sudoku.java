class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < 9; r ++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> blocks = new HashSet<>();
            int row = (r / 3) * 3, col = (r % 3) * 3;
            for (int c = 0; c < 9; c ++) {
                if (board[r][c] != '.' && !rows.add(board[r][c])) {
                    return false;
                }
                if (board[c][r] != '.' && !cols.add(board[c][r])) {
                    return false;
                }
                if (board[row + c /3][col + c % 3] != '.' && !blocks.add(board[row + c /3][col + c % 3])) {
                    return false;
                }
            }
        }
        return true;
    }
}
