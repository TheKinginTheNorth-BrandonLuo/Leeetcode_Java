class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int ROWS = mat.length, COLS = mat[0].length;
        int r = 0, c = 0;
        int[] res = new int[ROWS * COLS];
        
        for (int i = 0; i < res.length; i ++) {
            res[i] = mat[r][c];
            if ((r + c) % 2 == 0) {
                if (c == COLS - 1) {
                    r ++;
                }
                else if (r == 0) {
                    c ++;
                }
                else {
                    r --;
                    c ++;
                }
            }
            else {
                if (r == ROWS - 1) {
                    c ++;
                }
                else if (c == 0) {
                    r ++;
                }
                else {
                    r ++;
                    c --;
                }
            }
        }
        return res;
    }
}
