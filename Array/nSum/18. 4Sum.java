class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        
        for (int i = 0; i < nums.length - 3; i ++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 2; j ++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int low = j + 1, high = nums.length - 1, sum = target - nums[i] - nums[j];
                    while (low < high) {
                        if (nums[low] + nums[high] == sum) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                            while (low < high && nums[low] == nums[low + 1]) {
                            low ++;
                            }
                            while (low < high && nums[high] == nums[high - 1]) {
                                high --;
                            }
                            low ++;
                            high --;
                        }
                        else if (nums[low] + nums[high] < sum) {
                            low ++;
                        }
                        else {
                            high --;
                        }
                    }
                    }
                }
            }
        }
        return res;
    }
}
