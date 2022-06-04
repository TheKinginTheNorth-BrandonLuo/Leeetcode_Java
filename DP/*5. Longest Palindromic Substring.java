class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int finalStart = 0, finalLength = 1;
        for (int i = 0; i < n; i ++) {
            dp[i][i] = true;
        }
        
        for (int end = 0; end < n; end ++) {
            for (int start = end - 1; start >= 0; start --) {
                if (s.charAt(start) == s.charAt(end)) {
                    if (end - start == 1 || dp[start + 1][end - 1]) {
                        dp[start][end] = true;
                        int curLength = end - start + 1;
                        if (finalLength < curLength) {
                            finalStart = start;
                            finalLength = curLength;
                        }
                    }
                }
            }
        }
        return s.substring(finalStart, finalStart + finalLength);
    }
}
