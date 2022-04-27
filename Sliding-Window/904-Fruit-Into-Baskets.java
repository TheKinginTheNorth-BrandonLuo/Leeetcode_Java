class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> hash_map = new HashMap<>();
        int res = 0, l = 0, r = 0;
        
        while (r < fruits.length) {
            hash_map.put(fruits[r], r);
            if (hash_map.size() > 2) {
                int minVal = Collections.min(hash_map.values());
                hash_map.remove(fruits[minVal]);
                l = minVal + 1;
            }
            res = Math.max(res, r - l + 1);
            r += 1;
        }
        return res;
    }
}
