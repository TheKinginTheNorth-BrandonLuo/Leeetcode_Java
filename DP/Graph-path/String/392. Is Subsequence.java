class Solution {
    public boolean isSubsequence(String s, String t) {
        t = "!" + t;
        s = "!" + s;
        int ROWS = t.length(), COLS = s.length();
        int[][] dp = new int[ROWS][COLS];
        for (int[] row: dp) {
            Arrays.fill(row, 0);
        }
        for (int r = 0; r < ROWS; r ++) {
            dp[r][0] = 1;
        }
        
        for (int r = 1; r < ROWS; r ++) {
            for (int c = 1; c < COLS; c ++) {
                if (t.charAt(r) == s.charAt(c)) {
                    dp[r][c] = dp[r - 1][c - 1];
                }
                else {
                    dp[r][c] = dp[r - 1][c];
                }
            }
        }
        return dp[ROWS - 1][COLS - 1] != 0;
    }
}

class forLoopSolution {
    public boolean isSubsequence(String s, String t) {
        s = "!" + s;
        t = "!" + t;
        int pos = 0;
        int length_s = s.length();
        char[] chars = t.toCharArray();
        for (char ch: chars) {
            if (s.charAt(pos) == ch) {
                pos += 1;
                if (pos == length_s) {
                    return true;
                }
            }
        }
        return false;
    }
}
