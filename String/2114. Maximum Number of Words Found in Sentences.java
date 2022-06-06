class Solution {
    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for (String s: sentences) {
            res = Math.max(res, s.split(" ").length);
        }
        return res;
    }
}
