class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i ++) {
            Long floor = set.floor((long)nums[i]); // the first element less than nums[i]
            Long ceil = set.ceiling((long)nums[i]); // the first element greater than nums[i]
            
            if (floor != null && (long)nums[i] - floor <= t ) {
                return true;
            }
            if (ceil != null && ceil - (long)nums[i] <=  t) {
                return true;
            }
            
            set.add((long)nums[i]);
            if (set.size() > k) { // keet tree set size less than k
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}
