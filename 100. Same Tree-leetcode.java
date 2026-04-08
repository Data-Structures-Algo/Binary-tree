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
    public boolean isSameTree(TreeNode p, TreeNode q){
        //if there's no child nodes any more in both so both null
        if(p==null && q==null){
            return true;
        }
        //if p has child node and q don't and if q has child and p don't 
        if(p==null || q==null){
            return false;
        }
        //if value doesn't match
        if(p.val!=q.val){
            return false;
        }
        //check for left subtree and right subtree if both matches
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        
    }
}
