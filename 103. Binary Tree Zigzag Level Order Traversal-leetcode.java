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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>>result = new ArrayList<>();
        Queue<TreeNode>q= new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer>level = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode newNode = q.poll();
                // first add left to right
                if(leftToRight){
                   level.add(newNode.val); 
                }else{ // if previous was left to right now add right to left 
                    level.add(0,newNode.val);
                }
                if(newNode.left!=null) q.offer(newNode.left);
                if(newNode.right!=null) q.offer(newNode.right);
            }
            result.add(level);
            leftToRight =! leftToRight; // reverse the direction
        }
        return result;
    }
}
