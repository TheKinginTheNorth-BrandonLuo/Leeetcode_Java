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
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean res = false;
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == -1) {
                res = true;
            }
            else {
                if (res) {
                    return false;
                }
                queue.offer(node.left == null ? new TreeNode(-1) : node.left);
                queue.offer(node.right == null ? new TreeNode(-1) : node.right);
            }
        }
        return true;
    }
}
