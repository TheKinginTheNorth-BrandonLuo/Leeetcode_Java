class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int res = 0;
        for (int n : nums) {
            if (n == 1) {
                count += 1;
                res = Math.max(res, count);
            } else {
                count = 0;
            }
        }
        return res;
    }
}
