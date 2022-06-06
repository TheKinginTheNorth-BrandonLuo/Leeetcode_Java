class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        if (s.equals("")) {
            return 0;
        }
        
        int index = 0, sign = 1;
        long sum = 0;
        
        if (s.charAt(0) == '+') {
            sign = 1;
            index += 1;
        }
        else if (s.charAt(0) == '-') {
            sign = -1;
            index += 1;
        }
        for (int i = index; i < s.length(); i ++) {
            if (!Character.isDigit(s.charAt(i))) {
                return (int)(sign * sum);
            }
            sum = sum * 10 + (s.charAt(i) - '0');
            if (sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) sum * sign;
    }
}
