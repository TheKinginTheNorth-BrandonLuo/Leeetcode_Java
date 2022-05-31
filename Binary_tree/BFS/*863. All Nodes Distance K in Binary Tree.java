/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, List<TreeNode>> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null || k < 0) {
            return res;
        }
        toGraph(root, null);
        if (!map.containsKey(target)) {
            return res;
        }
        HashSet<TreeNode> visited = new HashSet<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(target);
        visited.add(target);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (k == 0) {
                for (int i = 0; i < size; i ++) {
                    res.add(queue.poll().val);
                }
                return res;
            }
            for (int i = 0; i < size; i ++) {
                TreeNode cur = queue.poll();
                for (TreeNode next: map.get(cur)) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    queue.offer(next);
                }
            }
            k --;
        }
        return res;
    }
    
    private void toGraph(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        if (!map.containsKey(node)) {
            map.put(node, new ArrayList<>());
            if (parent != null) {
                map.get(node).add(parent);
                map.get(parent).add(node);
            }
            toGraph(node.left, node);
            toGraph(node.right, node);
        }
    }
}
