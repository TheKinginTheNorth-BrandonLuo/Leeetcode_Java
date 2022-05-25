class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int[] row: dp) {
            Arrays.fill(row, 0);
        }
        
        for (int c = 0; c < s.length() + 1; c ++) {
            dp[0][c] = 1;
        }
        
        for (int i = 0; i < t.length(); i ++) {
            for (int j = 0; j < s.length(); j ++) {
                if (t.charAt(i) == s.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j];
                }
                else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
