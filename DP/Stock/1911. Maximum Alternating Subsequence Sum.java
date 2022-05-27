class Solution {
    public long maxAlternatingSum(int[] nums) {
        long odd = 0, even = 0;
        for (int n: nums) {
            even = Math.max(even, odd + n);
            odd = even - n;
        }
        return even;
    }
}
