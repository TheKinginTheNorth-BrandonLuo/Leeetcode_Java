class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0, prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int n: nums) {
            prefixSum += n;
            if (map.containsKey(prefixSum - k)) {
                res += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return res;
    }
}
