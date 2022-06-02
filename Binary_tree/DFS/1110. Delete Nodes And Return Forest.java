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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        HashSet<Integer> set = new HashSet<>();
        for (int i: to_delete) {
            set.add(i);
        }
        if (!set.contains(root.val)) {
            res.add(root);
        }
        dfs(root, set, res);
        return res;
    }
    
    private void dfs(TreeNode root, HashSet<Integer> set, List<TreeNode> res) {
        if (root != null) {
            dfs(root.left, set, res);
            dfs(root.right, set, res);
            if (root.left != null && set.contains(root.left.val)) {
                root.left = null;
            }
            if (root.right != null && set.contains(root.right.val)) {
                root.right = null;
            }
            if (set.contains(root.val)) {
                if (root.left != null) {
                    res.add(root.left);
                }
                if (root.right != null) {
                    res.add(root.right);
                }
            }
        }
    }
}
