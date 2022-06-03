class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i < words.length; i ++) {
            if (dfs(words[i], set, 0, new boolean[words[i].length()])) {
                res.add(words[i]);
            }
            set.add(words[i]);
        }
        return res;
    }
    
    private boolean dfs(String s, HashSet<String> set, int startIndex, boolean[] memo) {
        if (set.isEmpty()) {
            return false;
        }
        if (startIndex == s.length()) {
            return true;
        }
        
        for (int endIndex = startIndex + 1; endIndex < s.length() + 1; endIndex ++) {
            if (set.contains(s.substring(startIndex, endIndex)) && dfs(s, set, endIndex, memo)) {
                memo[startIndex] = true;
                return true;
            }
        }
        memo[startIndex] = false;
        return false;
    }
}
