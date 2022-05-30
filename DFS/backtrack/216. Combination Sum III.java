class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), k, n, 1);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> path, int k, int n, int start) {
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(path));
        }
        if (n < 0 || k < 0) {
            return;
        }
        for (int i = start; i <= 9; i ++) {
            path.add(i);
            backtrack(res, path, k - 1, n - i, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
