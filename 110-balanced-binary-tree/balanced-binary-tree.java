class Solution {
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return ans;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if(Math.abs(left-right)>1) ans = false;
        return Math.max(left, right)+1;
    }
}