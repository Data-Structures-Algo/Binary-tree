/*
    Following is the TreeNode class structure:

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.data = val;
            this.left = left;
            this.right = right;
        }
    };
*/

import java.util.List;
import java.util.*;

public class Solution {
    public static List< Integer > getInOrderTraversal(TreeNode root) {
        List<Integer>result=new ArrayList<>();
        inOrder(root,result);
        return result;


    }
    private static void inOrder(TreeNode root,List<Integer>result){
        if(root==null){
            return;
        }

        inOrder(root.left,result);
        result.add(root.data);
        inOrder(root.right,result);
    }
}

/* Pre-Order */
import java.util.* ;
import java.io.*; 
/*
	
	Following is the Binary Tree node structure:

	public class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.data = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	       this.data = val;
	        this.left = left;
	        this.right = right;
	    }
	}

*/

public class Solution {
    public static List < Integer > getPreOrderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private static void preOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.data); 
        preOrder(root.left, result); 
        preOrder(root.right, result); 
    }
}
