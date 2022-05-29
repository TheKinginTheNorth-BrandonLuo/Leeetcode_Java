class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        HashSet<Integer> rowMin = new HashSet<>();
        HashSet<Integer> colMin = new HashSet<>();
        
        for (int[] row: matrix) {
            int min = row[0];
            for (int r: row) {
                min = Math.min(min, r);
            }
            rowMin.add(min);
        }
        
        for (int c = 0; c < COLS; c ++) {
            int max = matrix[0][c];
            for (int r = 0; r < ROWS; r ++) {
                max = Math.max(max, matrix[r][c]);
            }
            if (rowMin.contains(max)) {
                colMin.add(max);
            }
        }
        return new ArrayList<>(colMin);
    }
}
