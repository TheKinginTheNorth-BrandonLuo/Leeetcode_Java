class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (n == 0 || n < k) {
            return 0;
        }
        if (k == 1) {
            return n;
        }
        int[] count = new int[26];
        for (char c: s.toCharArray()) {
            count[c - 'a'] += 1;
        }
        char target_char = 0;
        for (int i = 0; i < 26; i ++) {
            if (count[i] > 0 && count[i] < k) {
                target_char = (char)(i + 'a');
                break;
            }
        }
        
        if (target_char == 0) {
            return n;
        }
        String[] subs = s.split(String.valueOf(target_char));
        
        int res = 0;
        for (String sub: subs) {
            res = Math.max(res, longestSubstring(sub, k));
        }
        
        return res;
    }
}
