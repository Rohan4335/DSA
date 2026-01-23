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
 class Pair{
    TreeNode node;
    int idx;
    Pair(TreeNode n, int i){
        node = n;
        idx = i;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int maxWidth = -1;
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            int length = q.size();
            int start = q.peek().idx;
            int index = 0;
            for(int i = 0; i<length; i++){
                Pair p = q.poll();
                TreeNode pvt = p.node;
                index = p.idx;
                if(pvt.left != null){
                    q.add(new Pair(pvt.left, 2*index+1));
                }
                if(pvt.right != null){
                    q.add(new Pair(pvt.right, 2*index+2));
                }
            }
            maxWidth = Math.max(maxWidth, index - start +1);
        }
        return maxWidth;
    }
}