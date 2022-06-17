class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (int key: map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        
        int[] res = new int[k];
        
        for(int i = bucket.length - 1; i >= 0; i--) {
            if(bucket[i] == null) {
                continue;
            }
            for(int j = 0; j < bucket[i].size() && k > 0; j++) {
                k --;
                res[k] = bucket[i].get(j);
            }
        }
        return res;
    }
}
