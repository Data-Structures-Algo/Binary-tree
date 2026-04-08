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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>(); // to add levelwise
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll(); //remove and 
                level.add(curr.val); //add the front to the level (left->right)
                if (curr.left != null)
                    q.offer(curr.left); //keep adding the children from left to right
                if (curr.right != null)
                    q.offer(curr.right);
            }
            result.add(level);
        }
        return result;
    }
}
