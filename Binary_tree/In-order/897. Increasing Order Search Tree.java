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
    private TreeNode pre;
    private TreeNode res;
    
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return res;
    }
    
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (res == null) {
            res = root;
        }
        else {
            pre.right = root;
        }
        pre = root;
        root.left = null;
        inOrder(root.right);
    }
}
