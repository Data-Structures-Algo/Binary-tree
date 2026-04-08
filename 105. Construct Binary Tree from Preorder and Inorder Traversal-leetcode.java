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
    int preIdx = 0;
    Map<Integer,Integer>map = new HashMap<>(); //store inorder index for lookup
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i); // 2->0 , 9->1 ...
        }
        return build(preorder,0,inorder.length-1); //call build with preorder,start,end
    }
    private TreeNode build(int[] preorder, int start, int end){
        if(start>end) return null; //if there's no more to go left or right means start is bigger then null - base condition
        int rootval = preorder[preIdx++];
        TreeNode root = new TreeNode(rootval); //create root node

        int idx = map.get(rootval); // get the index of root to split 
        root.left = build(preorder,start,idx-1); // go for left subtree
        root.right = build(preorder,idx+1,end); // go for right subtree
        return root;
    }
}
