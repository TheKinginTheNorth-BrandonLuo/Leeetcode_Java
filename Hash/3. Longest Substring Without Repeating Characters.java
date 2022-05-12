class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        
        while (left < s.length() && right < s.length()) {
            if (set.contains(s.charAt(right))) {
                if (set.contains(s.charAt(left))) {
                    set.remove(s.charAt(left));
                    left += 1;
                }
            } else {
                set.add(s.charAt(right));
                right += 1;
                res = Math.max(res, set.size());
            }
        }
        return res;
    }
}
