class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int missing = t.length();
        int left = 0;
        String min_window = new String("");
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        int minLen = s.length() + 1;
        int minLeft = 0;
        
        for (int right = 0; right < s.length(); right ++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) >= 0) {
                    count += 1;
                }
                while (count == t.length()) {
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0) {
                            count -= 1;
                        }
                    }
                    left += 1;
                }
            }
            
        }
        if (minLen > s.length()) {
            return "";
        }
        
        return s.substring(minLeft, minLeft + minLen);
    }
}
