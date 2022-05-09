class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        HashSet<Character> hashSet = new HashSet<>();
        int count = 0;
        
        for (int i = 0; i < s.length(); i ++) {
            if (hashSet.contains(s.charAt(i))) {
                hashSet.remove(s.charAt(i));
                count += 1;
            } else {
                hashSet.add(s.charAt(i));
            }
        }
        if (!hashSet.isEmpty()) {
            return count * 2 + 1;
        }
        return count * 2;
    }
}
