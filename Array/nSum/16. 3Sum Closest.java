class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[nums.length - 1];
        int closestSum = sum;
        
        for (int i = 0; i < nums.length - 2; i ++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1, high = nums.length - 1;
                while (low < high) {
                    sum = nums[i] + nums[low] + nums[high];
                    if (sum < target) {
                        while (low < high && nums[low] == nums[low + 1]) {
                            low ++;
                        }
                        low ++;
                    }
                    else if (sum > target) {
                        while (low < high && nums[high] == nums[high - 1]) {
                            high --;
                        }
                        high --;
                    }
                    else {
                        return sum;
                    }
                    if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                        closestSum = sum;
                    }
                }
            }
        }
        return closestSum;
    }
}
