class Solution {
    public int firstMissingPositive(int[] nums) {
        int res = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }
        
        while (set.contains(res)) {
            res ++;
        }
        return res;
    }
}
