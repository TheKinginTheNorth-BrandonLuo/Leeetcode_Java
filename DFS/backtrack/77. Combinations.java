class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> path, int n, int k, int start) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
        }
        for (int i = start; i <= n; i ++) {
            path.add(i);
            backtrack(res, path, n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
