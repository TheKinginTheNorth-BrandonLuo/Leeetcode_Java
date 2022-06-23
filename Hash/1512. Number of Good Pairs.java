class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        
        for (int n : nums) {
            if (map.containsKey(n)) {
                res += map.get(n);
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            else {
                map.put(n, 1);
            }
        }
        return res;
    }
}
