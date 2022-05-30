class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }
    
    private void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i ++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            else {
                path.add(candidates[i]);
                backtrack(candidates, target - candidates[i], res, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
