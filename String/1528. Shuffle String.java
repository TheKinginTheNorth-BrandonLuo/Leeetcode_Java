class Solution {
    public String restoreString(String s, int[] indices) {
        char[] res = new char[s.length()];
        
        for (int i = 0; i < s.length(); i ++) {
            int index = indices[i];
            res[index] = s.charAt(i);
        }
        
        return String.valueOf(res);
    }
}
