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
    List<TreeNode> res = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return arrToBST(0, res.size() - 1);
    }
    
    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        res.add(root);
        inOrder(root.right);
        
    }
    
    TreeNode arrToBST(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = res.get(mid);
        root.left = arrToBST(start, mid - 1);
        root.right = arrToBST(mid + 1, end);
        return root;
    }
}
