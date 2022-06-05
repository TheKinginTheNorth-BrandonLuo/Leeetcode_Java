class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        
        int i = 0;
        while (i < nums.length) {
            int j = i;
            while (j < nums.length - 1 && nums[j] + 1 == nums[j + 1]) {
                j += 1;
            }
            if (j == i) {
                res.add(String.valueOf(nums[i]));
            }
            else {
                res.add(String.valueOf(nums[i]) + "->" + String.valueOf(nums[j]));
            }
            i = j + 1;
        }
        return res;
    }
}
