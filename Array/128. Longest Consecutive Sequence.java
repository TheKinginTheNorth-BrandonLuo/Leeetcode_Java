class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }
        
        for (int i: set) {
            if (!set.contains(i - 1)) {
                int start = i;
                while (set.contains(start)) {
                    start ++;
                }
                res = Math.max(res, start - i);
            }
        }
        return res;
    }
}
