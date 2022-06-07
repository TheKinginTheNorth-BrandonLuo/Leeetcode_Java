class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int left = 0, right = x;
        while (right > 0) {
            left = left * 10 + right % 10;
            right = right / 10;
        }
        return left == x;
    }
}
