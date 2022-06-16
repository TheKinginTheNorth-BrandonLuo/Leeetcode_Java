class Solution {
    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        int[] prime = new int[]{2, 3, 5};
        
        for (int p: prime) {
            while (n % p == 0) {
                n /= p;
            }
            if (n == 1) {
                return true;
            }
        }
        return false;
    }
}
