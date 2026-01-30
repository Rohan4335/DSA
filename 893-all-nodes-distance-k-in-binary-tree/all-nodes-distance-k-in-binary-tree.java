/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void parent(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parent(root,parentMap);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (level == k)
                break;
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if (current.left != null && visited.get(current.left) == null) {
                    q.offer(current.left);
                    visited.put(current.left, true);
                }
                if (current.right != null && visited.get(current.right) == null) {
                    q.offer(current.right);
                    visited.put(current.right, true);
                }
                if (parentMap.get(current) != null && visited.get(parentMap.get(current)) == null) {
                    q.offer(parentMap.get(current));
                    visited.put(parentMap.get(current), true);
                }
            }
            level++;
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }
}