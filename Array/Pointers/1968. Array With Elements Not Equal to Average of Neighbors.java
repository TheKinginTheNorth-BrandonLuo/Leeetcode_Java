class Solution {
    public int[] rearrangeArray(int[] nums) {
        int l = 0, r = nums.length - 1;
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        while (res.size() != n) {
            res.add(nums[l]);
            l += 1;
            
            if (l <= r) {
                res.add(nums[r]);
                r -= 1;
            }
        }
        // trick of converting arraylist to array
        int[] ans = res.stream().mapToInt(i -> i).toArray();
        return ans;
    }
}
