class Solution {
    int res = 0;
    public int maxLength(List<String> arr) {
        if (arr.size() == 0) {
            return 0;
        }
        dfs(arr, "", 0);
        return res;
    }
    
    private void dfs(List<String> arr, String subArr, int index) {
        if (npDuplicate(subArr)) {
            res = Math.max(res, subArr.length());
        }
        if (index == arr.size() || !npDuplicate(subArr)) {
            return;
        }
        for (int i = index; i < arr.size(); i ++) {
            dfs(arr, subArr + arr.get(i), i + 1);
        }
        
    }
    
    private boolean npDuplicate(String subArr) {
        int[] alpha = new int[26];
        for (int i = 0; i < subArr.length(); i ++) {
            alpha[subArr.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < alpha.length; i ++) {
            if (alpha[i] > 1) {
                return false;
            }
        }
        return true;
    }
}
