class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }
    
    private void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }
        for (int i = start; i < candidates.length; i ++) {
            if (candidates[i] > target) {
                break;
            }
            else {
                path.add(candidates[i]);
                backtrack(candidates, target - candidates[i], res, path, i);
                path.remove(path.size() - 1);
            }
        }
    }
}
