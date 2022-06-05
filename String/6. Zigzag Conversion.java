class Solution {
    public String convert(String s, int numRows) {
        if(numRows<=1) {
            return s;
        }
        
        String[] zigzag = new String[numRows];
        for (int i = 0; i < numRows; i ++) {
            zigzag[i] = "";
        }
        int row = 0, step = 1;
        for (char c: s.toCharArray()) {
            if (row == 0) {
                step = 1;
            }
            if (row == numRows - 1) {
                step = -1;
            }
            zigzag[row] += c;
            row += step;
        }
        StringBuilder sb = new StringBuilder();
        for (String str: zigzag) {
            sb.append(str);
        }
        return sb.toString();
    }
}
