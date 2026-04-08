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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int lcount = countNodes(root.left);
        int rcount = countNodes(root.right);
        return lcount+rcount+1;
    }
}
// height = height of leftsubtree + height of rightsubtree + 1 (also height = no. of nodes between two nodes like from root to leaf is the height)
