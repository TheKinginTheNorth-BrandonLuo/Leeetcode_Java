class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i ++) {
            if (visited[i]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            backtrack(nums, res, path, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
