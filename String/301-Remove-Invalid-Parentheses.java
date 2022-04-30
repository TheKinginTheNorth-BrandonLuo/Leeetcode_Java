class Solution {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> level = new HashSet<>();
        level.add(s);
        List<String> res = new ArrayList<>();
        
        while (!level.isEmpty()) {
            for (String p: level) {
                if (isValid(p)) {
                    res.add(p);
                }
            }
            if (!res.isEmpty()) {
                return res;
            }
            
            HashSet<String> newLevel = new HashSet<>();
            for (String p: level) {
                for (int i = 0; i < p.length(); i ++) {
                    newLevel.add(p.substring(0, i) + p.substring(i + 1));
                }
            }
            level = newLevel;
        }
        return res;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                count += 1;
            } else if (c == ')') {
                count -= 1;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
