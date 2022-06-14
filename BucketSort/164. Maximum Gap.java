class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        
        int low = nums[0], high = nums[0];
        for (int i: nums) {
            low = Math.min(low, i);
            high = Math.max(high, i);
        }
        
        if (low == high) {
            return 0;
        }
        
        int n = nums.length;
        
        int gap = (int)Math.ceil((double)(high - low) / (n - 1));
        int[] minBucket = new int[n];
        int[] maxBucket = new int[n];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        
        for (int i: nums) {
            int index = (i - low) / gap;
            minBucket[index] = Math.min(minBucket[index], i);
            maxBucket[index] = Math.max(maxBucket[index], i);
        }
        
        for (int i = 0; i < minBucket.length; i ++) {
            if (minBucket[i] != Integer.MAX_VALUE) {
                gap = Math.max(gap, minBucket[i] - low);
                low = maxBucket[i];
            }
        }
        return gap;
    }
}
