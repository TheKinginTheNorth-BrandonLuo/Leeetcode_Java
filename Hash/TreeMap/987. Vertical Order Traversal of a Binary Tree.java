/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        map = new TreeMap<>();
        dfs(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (int key : map.keySet()) {
            List<Integer> tmp = new ArrayList<>();
            TreeMap<Integer, PriorityQueue<Integer>> treemap = map.get(key);
            for (int k : treemap.keySet()) {
                PriorityQueue<Integer> pq = treemap.get(k);
                while (!pq.isEmpty()) {
                    tmp.add(pq.poll());
                }
            }
            res.add(tmp);
        }
        return res;
    }
    
    private void dfs(TreeNode root, int index, int level) {
        if (root == null) {
            return;
        }
        
        map.putIfAbsent(index, new TreeMap<>());
        map.get(index).putIfAbsent(level, new PriorityQueue<>());
        map.get(index).get(level).offer(root.val);
        dfs(root.left, index - 1, level + 1);
        dfs(root.right, index + 1, level + 1);
    }
}
