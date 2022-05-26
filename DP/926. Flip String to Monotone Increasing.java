class Solution {
    public int minFlipsMonoIncr(String s) {
        if (s.length() <= 1 || s == null) {
            return 0;
        }
        int n = s.length();
        int countEndwithOne = 0, countEndwithZero = 0;
        
        for (char c: s.toCharArray()) {
            countEndwithOne = Math.min(countEndwithOne, countEndwithZero) + (c == '1' ? 0 : 1);
            countEndwithZero += (c == '0' ? 0 : 1);
        }
        return Math.min(countEndwithOne, countEndwithZero);
    }
}

class secondSolution {
    public int minFlipsMonoIncr(String s) {
        int zero = 0;
        for (char c: s.toCharArray()) {
            if (c == '0') {
                zero += 1;
            }
        }
        int one = 0;
        int res = zero;
        
        for (char c: s.toCharArray()) {
            if (c == '0') {
                zero -= 1;
            }
            else {
                one += 1;
            }
            res = Math.min(res, zero + one);
        }
        return res;
    }
}
