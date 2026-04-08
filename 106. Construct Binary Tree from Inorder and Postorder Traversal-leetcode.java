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
    int postIdx;
    Map<Integer,Integer>map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(postorder,0,inorder.length-1);
    }
    private TreeNode build(int[] postorder,int start,int end){
        //same as Inorder and preorder just process right first then left and root from last
        //since root is at last of postorder
        if(start>end) return null;
        
        int rootval = postorder[postIdx--];
        TreeNode root = new TreeNode(rootval);

        int idx = map.get(rootval);

        root.right = build(postorder,idx+1,end);
        root.left = build(postorder,start,idx-1);
        return root;
    }
}
