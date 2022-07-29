/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private int i;
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        serializeDFS(root, list);
        return String.join(",", list);
        
    }
    
    public void serializeDFS(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("Null");
            return;
        }
        list.add(String.valueOf(root.val));
        serializeDFS(root.left, list);
        serializeDFS(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        return deserializeDFS(tokens);
    }
    
    public TreeNode deserializeDFS(String[] tokens) {
        String token = tokens[this.i];
        if (token.equals("Null")) {
            this.i ++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(token));
        this.i ++;
        root.left = deserializeDFS(tokens);
        root.right = deserializeDFS(tokens);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
