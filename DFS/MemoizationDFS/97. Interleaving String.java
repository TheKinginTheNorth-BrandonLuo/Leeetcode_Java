class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return memoDFS(s1, s2, s3, memo, 0, 0);
    }
    
    private boolean memoDFS(String s1, String s2, String s3, int[][] memo, int i, int j) {
        if (i == s1.length() && j == s2.length()) {
            return true;
        }
        if (memo[i][j] >= 0) {
            return memo[i][j] == 1? true : false;
        }
        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && memoDFS(s1, s2, s3, memo, i + 1, j)) {
            res = true;
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && memoDFS(s1, s2, s3, memo, i, j + 1)) {
            res = true;
        }
        memo[i][j] = res ? 1: 0;
        return res;
    }
}
