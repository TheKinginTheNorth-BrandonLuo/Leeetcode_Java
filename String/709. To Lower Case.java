class Solution {
    public String toLowerCase(String s) {
        char[] res = s.toCharArray();
        for (int i = 0; i < s.length(); i ++) {
            if ('A' <= res[i] && res[i] <= 'Z') {
                res[i] = (char)(res[i] - 'A' + 'a');
            }
        }
        return new String(res);
    }
}
