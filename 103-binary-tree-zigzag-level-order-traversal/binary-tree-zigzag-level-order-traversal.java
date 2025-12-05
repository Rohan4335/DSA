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
        Deque<TreeNode> q = new LinkedList<>();
        if(root == null) return result;
        q.addFirst(root);
        boolean even = false;
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int n = q.size();
            for(int i=0; i<n; i++){
                if(!even){
                    TreeNode curr = q.pollFirst();
                    list.add(curr.val);
                    if(curr.left != null) q.addLast(curr.left);
                    if(curr.right != null) q.addLast(curr.right);
                }else{
                    TreeNode curr = q.pollLast();
                    list.add(curr.val);
                    if(curr.right != null) q.addFirst(curr.right);
                    if(curr.left != null) q.addFirst(curr.left);
                }
            }
            result.add(list);
            even =! even;
        }
        return result;
    }
}