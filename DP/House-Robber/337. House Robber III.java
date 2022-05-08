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
    public int rob(TreeNode root) {
        int[] nums = dfs(root);
        return Math.max(nums[0], nums[1]);
    }
    public int[] dfs(TreeNode root){
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] leftPairs = dfs(root.left);
        int[] rightPairs = dfs(root.right);
        
        int[] res = new int[2];
        res[0] = root.val + leftPairs[1] + rightPairs[1];
        res[1] = Math.max(leftPairs[0], leftPairs[1]) + Math.max(rightPairs[0], rightPairs[1]);
        return res;
    }
}
