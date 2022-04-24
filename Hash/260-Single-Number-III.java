class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> hash_set = new HashSet<>();
        
        for (int n: nums) {
            if (hash_set.contains(n)) {
                hash_set.remove(n);
            } else {
                hash_set.add(n);
            }
        }
        int n = hash_set.size();
        int arr[] = new int[n];
  
        int i = 0;
        for (int x : hash_set)
            arr[i++] = x;
  
        return arr;
    }
}
