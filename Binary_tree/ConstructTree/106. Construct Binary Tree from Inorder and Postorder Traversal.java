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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return construct(postorder.length - 1, inorder.length - 1, 0, postorder, inorder);
    }
    
    private TreeNode construct(int postStart, int inStart, int inEnd, int[] postorder, int[] inorder) {
        if (postStart < 0 || inStart < inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postStart]);
        int inIndex = inStart;
        for (int i = inStart; i >= inEnd; i --) {
            if (inorder[i] == postorder[postStart]) {
                inIndex = i;
                break;
            }
        }
        root.right = construct(postStart - 1, inStart, inIndex + 1, postorder, inorder);
        root.left = construct(postStart - (inStart - inIndex) - 1, inIndex - 1, inEnd, postorder, inorder);
        
        return root;
    }
}
