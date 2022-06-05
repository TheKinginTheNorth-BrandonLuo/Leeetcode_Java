class Solution {
    public int titleToNumber(String columnTitle) {
        int number = 0;
        
        for (char c: columnTitle.toCharArray()) {
            number *= 26;
            number += c - 'A' + 1;
        }
        
        return number;
    }
}
