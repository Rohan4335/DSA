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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, root, 0);
        return result;
        
    }
    private void helper(List<List<Integer>> result, TreeNode root, int level){
        if(root == null) return;
        if(level == result.size()){
            result.add(new LinkedList<>());
        }
        if(level %2 == 0){
            result.get(level).addLast(root.val);
        }else{
            result.get(level).addFirst(root.val);
        }

        helper(result, root.left, level+1);
        helper(result, root.right, level+1);
    }
}