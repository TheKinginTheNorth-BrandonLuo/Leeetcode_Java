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
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return res;
    }
    
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        res = Math.max(res, leftDepth + rightDepth);
        
        return Math.max(leftDepth, rightDepth) + 1;
        
    }
}
