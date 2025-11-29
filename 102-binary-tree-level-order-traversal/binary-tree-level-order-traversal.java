class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> res = new ArrayList<>();

        if(root == null)
        {
            return res;
        }

        queue.add(root);

        while(!queue.isEmpty())
        {
            int levelSize = queue.size();

            List<Integer> level = new ArrayList<>();
            for(int i=0; i<levelSize; i++)
            {
                TreeNode node = queue.poll();
                
                level.add(node.val);

                if(node.left!=null)
                {
                    queue.add(node.left);
                }

                if(node.right!=null)
                {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }

        return res;

    }
}