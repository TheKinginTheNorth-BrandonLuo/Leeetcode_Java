class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, res, new ArrayList<>(), 0);
        return res;
    }
    
    private void backtrack(String s, List<List<String>> res, List<String> path, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
        }
        
        for (int i = start; i < s.length(); i ++) {
            if (isPalindrome(s, start, i)) {
                path.add(s.substring(start, i + 1));
                backtrack(s, res, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low ++) != s.charAt(high --)) {
                return false;
            }
        }
        return true;
    }
}
