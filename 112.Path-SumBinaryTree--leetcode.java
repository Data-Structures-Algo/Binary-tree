// Top Interview 150 -> Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        // here we are checking if we are at leaf node?
        // if yes-> then return the leaf as sum
        if(root.left==null && root.right==null){
            return root.val==targetSum;
        }
        // now we have initialized a new target for we can find the required path sum
        // updating and tracking the remaining sum after visiting a node
        int newTarget=targetSum-root.val;

        // recursivley finding the path equals to the sum and if exists return true
        return hasPathSum(root.left,newTarget) || hasPathSum(root.right,newTarget);
        
    }
   
}
