class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        int maxFirst = 0, maxSecond = 0, res = 0;
        for (int i = 0; i < n; i ++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        for (int i = secondLen; i < prefix.length - firstLen; i ++) {
            maxSecond = Math.max(maxSecond, prefix[i] - prefix[i - secondLen]);
            res = Math.max(res, maxSecond + prefix[i + firstLen] - prefix[i]);
        }
        
        for (int i = firstLen; i < prefix.length - secondLen; i ++) {
            maxFirst = Math.max(maxFirst, prefix[i] - prefix[i - firstLen]);
            res = Math.max(res, maxFirst + prefix[i + secondLen] - prefix[i]);
        }
        
        return res;
    }
}
