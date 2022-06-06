class Solution {
    public int balancedStringSplit(String s) {
        int L_count = 0;
        int R_count = 0;
        int res = 0;
        //String[] substrings = s.split("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                L_count += 1;
            } else {
                R_count += 1;
            }
            if (L_count == R_count) {
                res += 1;
            }
        }
        return res;
    }
}
