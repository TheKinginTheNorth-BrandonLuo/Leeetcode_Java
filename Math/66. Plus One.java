class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // 19299 as example
        //when digit is 9 continue converting them to 0s
        // when 2 is less than 9, add 1 to 2 and return
        for (int i = n - 1; i >= 0; i --) {
            if (digits[i] < 9) {
                digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }
        
        // for 9999 => 10000
        // default zeros except 1st place
        int[] res = new int[n + 1];
        res[0] = 1;
        
        return res;
    }
}
