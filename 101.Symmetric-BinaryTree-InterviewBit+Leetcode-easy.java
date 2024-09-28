//Top Interview 150
/* Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).   */
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left = null;
 *      right = null;
 *     }
 * }
 */
//Interviewbit
public class Solution {
    public int isSymmetric(TreeNode A) {
        if (A == null) {
            return 1;  // An empty tree is symmetric
        }
        return isMirror(A.left, A.right) ? 1 : 0;
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;  // Both subtrees are empty, they are symmetric
        }
        if (left == null || right == null) {
            return false;  // One subtree is empty and the other is not, not symmetric
        }
        // Check if current nodes are equal and their respective subtrees are mirrors of each other
        return (left.val == right.val) &&
               isMirror(left.left, right.right) &&
               isMirror(left.right, right.left);
    }
}
//Leetcode ans
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;  // An empty tree is symmetric
        }
        return isMirror(root.left, root.right); 
    }
    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;  // Both subtrees are empty, they are symmetric
        }
        if (left == null || right == null) {
            return false;  // One subtree is empty and the other is not, not symmetric
        }
        // Check if current nodes are equal and their respective subtrees are mirrors of each other
        return (left.val == right.val) &&
               isMirror(left.left, right.right) &&
               isMirror(left.right, right.left);
    }
}
.java
