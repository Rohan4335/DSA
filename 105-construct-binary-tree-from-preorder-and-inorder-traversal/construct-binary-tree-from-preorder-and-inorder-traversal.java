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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder,map, 0, 0, inorder.length-1);
    }
    public TreeNode helper(int[] preorder, Map<Integer, Integer> map, int rootIndex, int left, int right){
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int mid = map.get(preorder[rootIndex]);
        if(left < mid){
            root.left = helper(preorder,map, rootIndex+1, left, mid-1);
        }
        if(right > mid){
            root.right = helper(preorder,map, rootIndex+mid-left+1, mid+1, right);
        }
        return root;
    }
}