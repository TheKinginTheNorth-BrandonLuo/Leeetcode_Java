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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<Integer> qIndex = new ArrayDeque<>();
        queue.offer(root);
        qIndex.offer(1);
        int res = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = 0, end = 0;
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                int index = qIndex.poll();
                if (i == 0) {
                    start = index;
                }
                if (i == size - 1) {
                    end = index;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    qIndex.offer(2 * index);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    qIndex.offer(2 * index + 1);
                }
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
