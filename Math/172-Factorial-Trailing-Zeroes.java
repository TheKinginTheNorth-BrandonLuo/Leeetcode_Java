class Solution {
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        int r = 0;
        while (n > 0) {
            n = n / 5;
            r += n;
        }
        return r;
    }
}
