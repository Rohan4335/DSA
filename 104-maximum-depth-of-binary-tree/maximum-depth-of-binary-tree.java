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
    public int maxDepth(TreeNode root) {
        
        int max = helper( root, 0, 0);
        return max;
    }

    public int helper(TreeNode root, int count, int maxcount){
        if(root == null){
            return Math.max(count, maxcount);
        }
        int left = helper(root.left, count+1, maxcount);
        int right = helper(root.right, count+1, maxcount);
        return Math.max(left, right);
    }
}