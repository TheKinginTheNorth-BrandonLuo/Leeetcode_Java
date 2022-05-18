class Solution {
    public List<List<String>> solveNQueens(int n) {
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> posDiag = new HashSet<>();
        HashSet<Integer> negDiag = new HashSet<>();
        
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                board[i][j] = '.';
            }
        }
        dfs(0, n, board, col, posDiag, negDiag, res);
        return res;
        
    }
    
    private void dfs(int r, int n, char[][] board, HashSet col, HashSet posDiag, HashSet negDiag, List<List<String>> res) {
        if (r == n) {
            List<String> list = new ArrayList<String>();
            for (char[] row: board) {
                list.add(new String(row));
            }
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int c = 0; c < n; c ++) {
            if (col.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }
            col.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = 'Q';
            
            dfs(r + 1, n, board, col, posDiag, negDiag, res);
            
            col.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
            board[r][c] = '.';
        }
    }
}
