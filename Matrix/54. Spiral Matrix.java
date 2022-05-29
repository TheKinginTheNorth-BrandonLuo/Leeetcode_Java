class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int startRow = 0, startCol = 0, endRow = matrix.length, endCol = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        
        while (startRow < endRow || startCol < endCol) {
            // right
            if (startRow < endRow) {
                for (int i = startCol; i < endCol; i ++) {
                    res.add(matrix[startRow][i]);
                }
            }
            startRow += 1;
            
            // down
            if (startCol < endCol) {
                for (int i = startRow; i < endRow; i ++) {
                    res.add(matrix[i][endCol - 1]);
                }
            }
            endCol -= 1;
            
            // left
            if (startRow < endRow) {
                for (int i = endCol - 1; i >= startCol; i --) {
                    res.add(matrix[endRow - 1][i]);
                }
            }
            endRow -= 1;
            
            // up
            if (startCol < endCol) {
                for (int i = endRow - 1; i >= startRow; i --) {
                    res.add(matrix[i][startCol]);
                }
            }
            startCol += 1;
        }
        return res;
    }
}
