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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> visited = new HashSet<>();
        return dfs(root, k, visited);
    }
    
    private boolean dfs(TreeNode root, int k, HashSet<Integer> visited) {
        if (root == null) {
            return false;
        }
        if (visited.contains(k - root.val)) {
            return true;
        }
        visited.add(root.val);
        return dfs(root.left, k, visited) || dfs(root.right, k, visited);
    }
}
