class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0] == null) {
            return false;
        }
        int ROWS = matrix.length, COLS = matrix[0].length;
        int row = 0, col = COLS - 1;
        
        while (row <= ROWS - 1 && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] > target) {
                col -= 1;
            }
            else {
                row += 1;
            }
        }
        return false;
    }
}
