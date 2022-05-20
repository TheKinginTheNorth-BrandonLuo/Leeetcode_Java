class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        char letters[] = s.toCharArray();
        int l = 0, r = removable.length - 1;
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            for (int i = 0; i <= mid; i ++) {
                letters[removable[i]] = '*';
            }
            if(valid(letters, p)) {
                l = mid + 1;
            }
            else {
                for (int i = 0; i <= mid; i ++) {
                    letters[removable[i]] = s.charAt(removable[i]);
                    r = mid - 1;
                }
            }
        }
        return l;
    }
    
    private boolean valid(char letters[], String p) {
        int i = 0, j = 0;
        while(i < letters.length && j < p.length()) {
            if (letters[i] == p.charAt(j)) {
                j ++;
            }
            i += 1;
        }
        return j == p.length();
    }
}
