class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for (int i: nums) {
            HashMap<Integer, Integer> subMap = new HashMap<>();
            for (int y: map.keySet()) {
                subMap.put(y - i, subMap.getOrDefault(y - i, 0) + map.get(y));
                subMap.put(y + i, subMap.getOrDefault(y + i, 0) + map.get(y));
            }
            map = subMap;
        }
        return map.getOrDefault(target, 0);
    }
}
