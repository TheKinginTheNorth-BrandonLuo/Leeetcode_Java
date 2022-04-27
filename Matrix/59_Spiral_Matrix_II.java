class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1;
        int num = 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i ++) {
                res[rowBegin][i] = num;
                num += 1;
            }
            rowBegin ++;
            
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res[j][colEnd] = num;
                num += 1;
            }
            colEnd --;
            
            for (int i = colEnd; i >= colBegin; i --) {
                res[rowEnd][i] = num;
                num += 1;
            }
            rowEnd --;
            
            for (int j = rowEnd; j >= rowBegin; j --) {
                res[j][colBegin] = num;
                num += 1;
            }
            colBegin ++;
        }
        return res;
        
    }
}
