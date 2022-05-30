class Solution {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        
        dfs(0, 0, "", s, res);
        return res;
    }
    
    private void dfs(int i, int dots, String curIP, String s, List<String> res) {
        if (dots == 4 && i == s.length()) {
            res.add(curIP.substring(0, curIP.length() - 1));
            return;
        }
        for (int j = i; j < Math.min(i + 3, s.length()); j ++) {
            if (Integer.parseInt(s.substring(i, j + 1)) <= 255 && (i == j || s.charAt(i) != '0')) {
                dfs(j + 1, dots + 1, curIP + s.substring(i, j + 1) + '.', s, res);
            }
        }
    }
}
