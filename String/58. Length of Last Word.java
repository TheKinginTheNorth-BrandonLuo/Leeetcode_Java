class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0, realCount = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == ' ') {
                realCount = 0;
            }
            else {
                realCount += 1;
                count = realCount;
            }
        }
        return count;
    }
}
