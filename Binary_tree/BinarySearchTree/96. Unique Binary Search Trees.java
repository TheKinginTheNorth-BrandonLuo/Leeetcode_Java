class Solution {
    public int numTrees(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(1);
        
        for (int i = 2; i < n + 1; i ++) {
            int count = 0;
            for (int j = 0; j < i; j ++) {
                // we take j as root, there are j nodes as left and i - j - 1 as right nodes
                // so the permutation would be j * (i - j - 1) to construct BST
                count += res.get(j) * res.get(i - j - 1);
            }
            res.add(count);
        }
        return res.get(res.size() - 1);
    }
}
