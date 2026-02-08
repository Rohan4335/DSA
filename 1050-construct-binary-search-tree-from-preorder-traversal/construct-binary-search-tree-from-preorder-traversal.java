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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length);
    }
    public TreeNode helper(int[] preorder, int rootIndex, int right){
        if(rootIndex >=right) return null;
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int i = rootIndex+1;
        while(i<=preorder.length-1 && preorder[i] < preorder[rootIndex]){
            i++;
        }
        root.left = helper(preorder,rootIndex+1, i);
        root.right = helper(preorder,i, right);
        return root;
    }
}