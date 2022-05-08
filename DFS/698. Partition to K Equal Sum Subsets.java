class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) {
            return false;
        }
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        if (sum % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        return dfs(nums, 0, nums.length - 1, visited, sum / k, k);
    }
    
    private boolean dfs(int[] nums, int sum, int start, boolean[] visited, int target, int round) {
        if (round == 0) {
            return true;
        }
        if (sum == target && dfs(nums, 0, nums.length - 1, visited, target, round - 1)) {
            return true;
        }
        for (int i = start; i >= 0; i --) {
            if (!visited[i] && sum + nums[i] <= target) {
                visited[i] = true;
                if (dfs(nums, sum + nums[i], i - 1, visited, target, round)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
