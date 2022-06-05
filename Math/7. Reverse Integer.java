class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int remainder = x % 10;
            int newRes = res * 10 + remainder;
            if ((newRes - remainder) / 10 != res) { // avoid overflow
                return 0;
            }
            res = newRes;
            x = x / 10;
        }
        return res;
    }
}
