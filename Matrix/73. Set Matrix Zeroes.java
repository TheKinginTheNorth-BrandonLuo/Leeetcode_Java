class Solution {
    public void setZeroes(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        boolean firstRow = false, firstCol = false;
        
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (matrix[r][c] == 0) {
                    if (r == 0) {
                        firstRow = true;
                    }
                    if (c == 0) {
                        firstCol = true;
                    }
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        
        for (int r = 1; r < ROWS; r ++) {
            for (int c = 1; c < COLS; c ++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }
        
        if (firstRow) {
            for (int c = 0; c < COLS; c ++) {
                matrix[0][c] = 0;
            }
        }
        
        if (firstCol) {
            for (int r = 0; r < ROWS; r ++) {
                matrix[r][0] = 0;
            }
        }
    }
}
