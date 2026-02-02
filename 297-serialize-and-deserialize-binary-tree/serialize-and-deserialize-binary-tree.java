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
    static TreeNode root;
    static String data;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        this.root = root;
        return data;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        this.data = data;
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));