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
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Double> res = new ArrayList<>();
        List<Double> level = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            double curSum = 0;
            for (int i = 0; i < size; i ++) {
                TreeNode cur = queue.poll();
                level.add(Double.valueOf(cur.val));
                curSum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(curSum / Double.valueOf(level.size()));
            level = new ArrayList<>();
        }
        return res;
    }
}
