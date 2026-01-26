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
    ArrayList<Integer> list = new ArrayList<>();
    int max = 0;
    public int widthOfBinaryTree(TreeNode root) {
        helper(root, 0, 0);
        return max;
    }
    public void helper(TreeNode root, int level, int index){
        if(root == null) return;
        if(list.size() == level){
            list.add(index);
        }
        int currWidth = Math.abs(list.get(level)-index)+1;
        max = Math.max(currWidth, max);
        helper(root.left, level+1, 2*index+1);
        helper(root.right, level+1, 2*index+2);
    }
}