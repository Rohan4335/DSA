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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        TreeNode l = root.left;
        TreeNode r = root.right;
        return helper(l,r);
    }
    public boolean helper(TreeNode l, TreeNode r){
        if(l == null && r == null) return true;
        if(l == null || r == null || l.val != r.val) return false;
        return helper(l.left, r.right) && helper(l.right, r.left);
    }
}