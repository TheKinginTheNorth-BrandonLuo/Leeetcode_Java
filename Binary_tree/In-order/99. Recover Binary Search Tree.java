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
    // inOrder traversal
    // root = [6,2,5,null,null,null,3]
    // Inorder traversal: [2,6,5,3]
    // First incorrect node/element is 6 because 6 > 5 (first == null && prev > curr) => prev is the first node.
// Second incorrect node/element is 3, because 5 > 3 (first != null && prev > curr), curr is the second node.
// To cover the edge-case of 2 consecutive elements to be swapped, we always assign second = curr.
    TreeNode first = null, second = null, pre = null;
    
    public void recoverTree(TreeNode root) {
        searchTree(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    private void searchTree(TreeNode root) {
        if (root == null) {
            return;
        }
        searchTree(root.left);
        if (pre != null && pre.val > root.val) {
            if (first == null) {
                first = pre;
            }
            second = root;
        }
        pre = root;
        searchTree(root.right);
    }
}
