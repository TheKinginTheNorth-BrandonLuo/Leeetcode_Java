class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersectSize = new HashSet<>();
        
        for (int n: nums1) {
            set.add(n);
        }
        
        for (int n: nums2) {
            if (set.contains(n)) {
                intersectSize.add(n);
            }
        }
        
        int[] res = new int[intersectSize.size()];
        int index = 0;
        for (int n: intersectSize) {
            res[index] = n;
            index ++;
        }
        
        return res;
    }
}
