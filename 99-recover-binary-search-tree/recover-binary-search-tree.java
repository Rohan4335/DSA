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
    TreeNode prev = null;
    TreeNode pivot1 = null;
    TreeNode pivot2 = null;
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = pivot1.val;
        pivot1.val = pivot2.val;
        pivot2.val = temp;
    }
    public void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        if(prev != null && root.val < prev.val){
            if(pivot1 == null){
                pivot1 = prev;
                pivot2 = root;
            }else{
                pivot2 = root;
            }
        }
        prev = root;
        helper(root.right);
    }
}