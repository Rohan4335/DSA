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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        while(root != null){
            if(root.left == null){
                ans.add(root.val);
                root = root.right;
            }else{
                TreeNode ip = root.left;
                while(ip.right != null && ip.right != root){
                    ip = ip.right;
                }
                if(ip.right == null){
                    ip.right = root;
                    root = root.left;
                }else{
                    ip.right = null;
                    ans.add(root.val);
                    root = root.right;
                }
            }
        }
        return ans;
    }
}