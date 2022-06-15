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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int nodes = 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        if (leftHeight == rightHeight) {
            nodes = (int)Math.pow(2, leftHeight) + (int)countNodes(root.right);
        }
        else {
            nodes = (int)Math.pow(2, rightHeight) + (int)countNodes(root.left);
        }
        return nodes;
    }
    
    private int getHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height += 1;
            root = root.left;
        }
        return height;
    }
}
