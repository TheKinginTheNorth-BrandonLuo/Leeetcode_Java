class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        int n = s1.length();
        
        for (int i = 0; i < s2.length(); i ++) {
            if (map.containsKey(s2.charAt(i))) {
                map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
                if (map.get(s2.charAt(i)) == 0) {
                    res += 1;
                }
            }
            if (i >= n && map.containsKey(s2.charAt(i - n))) {
                if (map.get(s2.charAt(i - n)) == 0) {
                    res -= 1;
                }
                map.put(s2.charAt(i - n), map.getOrDefault(s2.charAt(i - n), 0) + 1);
            }
            if (res == map.size()) {
                return true;
            }
        }
        return false;
    }
}
