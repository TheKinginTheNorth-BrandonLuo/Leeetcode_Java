class Solution {
    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] posDiag = new boolean[2 * n - 1];
        boolean[] negDiag = new boolean[2 * n - 1];
        
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                board[i][j] = '.';
            }
        }
        dfs(0, n, board, col, posDiag, negDiag, res);
        return res.size();
        
    }
    
    private void dfs(int r, int n, char[][] board, boolean[] col, boolean[] posDiag, boolean[] negDiag, List<List<String>> res) {
        if (r == n) {
            List<String> list = new ArrayList<String>();
            for (char[] row: board) {
                list.add(new String(row));
            }
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int c = 0; c < n; c ++) {
            if (col[c] || posDiag[r + c] || negDiag[r - c + n - 1]) {
                continue;
            }
            col[c] = true;
            posDiag[r + c] = true;
            negDiag[r - c + n - 1] = true;
            board[r][c] = 'Q';
            
            dfs(r + 1, n, board, col, posDiag, negDiag, res);
            
            col[c] = false;
            posDiag[r + c] = false;
            negDiag[r - c + n - 1] = false;
            board[r][c] = '.';
        }
    }
}
