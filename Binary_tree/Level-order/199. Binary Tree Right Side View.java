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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<TreeNode> level = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode cur = queue.poll();
                if (i == size - 1) {
                    res.add(cur.val);
                }
                if (cur.left != null) {
                    level.add(cur.left);
                }
                if (cur.right != null) {
                    level.add(cur.right);
                }
            }
            queue = level;
            level = new LinkedList<>();
        }
        return res;
    }
}
