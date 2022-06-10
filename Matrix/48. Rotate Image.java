class Solution {
    public void rotate(int[][] matrix) {
//             1  2  3             
//             4  5  6
//             7  8  9
//             flip symmetrically
            
//             1  4  7
//             2  5  8
//             3  6  9
//             flip horizontally
//             7  4  1
//             8  5  2
//             9  6  3
        int ROWS = matrix.length, COLS = matrix[0].length;
        
        for (int r = 0; r < ROWS; r ++) {
            for (int c = r; c < COLS; c ++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = tmp;
            }
        }
        
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS / 2; c ++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[r][ROWS - 1 - c];
                matrix[r][ROWS - 1- c] = tmp;
            }
        }
    }
}
