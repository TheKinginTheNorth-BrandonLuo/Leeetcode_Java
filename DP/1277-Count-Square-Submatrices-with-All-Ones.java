class Solution {
    public int countSquares(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int count = 0;
        
        for (int c = 0; c < COLS; c ++) {
            if (matrix[0][c] == 1) {
                count += 1;
            }
        }
        for (int r = 1; r < ROWS; r ++) {
            if (matrix[r][0] == 1) {
                count += 1;
            }
        }
        
        for (int r = 1; r < ROWS; r ++) {
            for (int c = 1; c < COLS; c ++) {
                if (matrix[r][c] == 1 && matrix[r - 1][c] > 0 && matrix[r][c - 1] > 0 && matrix[r - 1][c - 1] > 0) {
                    matrix[r][c] += Math.min(matrix[r - 1][c], Math.min(matrix[r][c - 1], matrix[r - 1][c - 1]));
                }
                count += matrix[r][c];
            }
        }
        return count;
    }
}
