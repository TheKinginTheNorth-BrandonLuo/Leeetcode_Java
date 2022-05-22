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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> level = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        stack1.push(root);
        
        while (!stack1.empty() || !stack2.empty()) {
            while (!stack1.empty()) {
                TreeNode cur = stack1.pop();
                level.add(cur.val);
                if (cur.left != null) {
                    stack2.push(cur.left);
                }
                if (cur.right != null) {
                    stack2.push(cur.right);
                }
            }
            res.add(level);
            level = new ArrayList<>();
            
            while (!stack2.empty()) {
                TreeNode cur = stack2.pop();
                level.add(cur.val);
                if (cur.right != null) {
                    stack1.push(cur.right);
                }
                if (cur.left != null) {
                    stack1.push(cur.left);
                }
            }
            
            if (!level.isEmpty()) {
                res.add(level);
                level = new ArrayList<>();
            }
        }
        return res;
    }
}
