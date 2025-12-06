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
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper(list, 0, root);
        for(List<Integer> x: list){
            ans.add(x.get(0));
        }
        return ans;
    }
    public void helper(List<List<Integer>> list, int level, TreeNode root){
        if(root == null) return;
        if(level >= list.size()){
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        helper(list, level+1, root.right);
        helper(list, level+1, root.left);
    }
}