class Solution {
    public boolean isMatch(String s, String p) {
//         s='aab', p='c*a*b'

//               c * a * b 
//             0 1 2 3 4 5
//           0 y n y n y n
//         a 1 n n n y y n
//         a 2 n n n n y n
//         b 3 n n n n n y
        if (p == null || p.length() == 0) {
            return (s == null || s.length() == 0);
        }
        
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        
        for (int j = 2; j < p.length() + 1; j ++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }
//         System.out.println(dp[0][2]);
        
        for (int i = 1; i < s.length() + 1; i ++) {
            for (int j = 1; j < p.length() + 1; j ++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || ((s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j]);
                }
            }
        } 
        return dp[s.length()][p.length()];
    }
}
