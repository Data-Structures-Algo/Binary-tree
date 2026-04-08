import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class demo {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree{
        static int idx = -1;
        public Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
        public void PreOrderTraversal(Node root){
            if(root==null){
                System.out.print("-1 ");
                return;
            }
            System.out.print(root.data+" ");
            PreOrderTraversal(root.left);
            PreOrderTraversal(root.right);
        }
        public void InOrderTraversal(Node root){
            if(root==null){
                System.out.print("null ");
                return;
            }
            InOrderTraversal(root.left);
            System.out.print(root.data+" ");
            InOrderTraversal(root.right);
        }
        public void PostOrderTraversal(Node root){
            if(root==null){
                System.out.print("null ");
                return;
            }
            PostOrderTraversal(root.left);
            PostOrderTraversal(root.right);
            System.out.print(root.data+" ");
        }
        public void LevelOrderTraversal(Node root){
            if(root==null) return;
            Queue<Node>q= new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0;i<size;i++){
                    Node currNode = q.poll();
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null) q.offer(currNode.left);
                    if(currNode.right!=null) q.offer(currNode.right);
                }
                System.out.println();
            }
        }
        public int countofNodes(Node root) {
            if (root == null) return 0;
            int lcount = countofNodes(root.left);
            int rcount = countofNodes(root.right);
            return lcount+rcount+1;
        }
        public int height(Node root){
            if(root==null) return 0;
            int lheight = height(root.left);
            int rheight = height(root.right);
            int myheight = Math.max(lheight,rheight)+1;
            return myheight;
        }
        //Approach 1 - (n^2)
        public int diameter(Node root){
            if(root==null) return 0;
            int diam1 = diameter(root.left);
            int diam2 = diameter(root.right);
            int diam3 = height(root.left) + height(root.right)+1;
            return Math.max(diam3,Math.max(diam1,diam2));
        }
        //Optimized Diameter approach with height - O(n) using Treeinfo class
        static class TreeInfo{
            int diam;
            int ht;
            TreeInfo(int diam,int ht){
                this.diam=diam;
                this.ht=ht;
            }
        }
        public TreeInfo diameterOptimized(Node root){
            if(root==null) return new TreeInfo(0,0);
            TreeInfo left = diameterOptimized(root.left);
            TreeInfo right = diameterOptimized(root.right);

            int height = Math.max(left.ht,right.ht)+1;

            int diam1 = left.diam;
            int diam2 = right.diam;
            int diam3 = left.ht+ right.ht + 1;
            int finaldiam = Math.max(diam3,Math.max(diam1,diam2));

            TreeInfo myinfo = new  TreeInfo(finaldiam,height);
            return myinfo;

        }
        public boolean isSubtree(Node root, Node subroot){
            if(root==null && subroot==null) return true;
            if(root==null || subroot==null) return false;
            if(isSame(root,subroot)){
                return true;
            }
            return isSame(root.left,subroot) || isSame(root.right,subroot);
        }
        public boolean isSame(Node root, Node subroot){
            if(root==null && subroot==null) return true;
            if(root==null || subroot==null) return false;
            if(root.data!=subroot.data) return false;
            return isSame(root.left,subroot.left) && isSame(root.right,subroot.right);
        }


    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        
        BinaryTree tree= new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root: "+root.data);
        System.out.println("PreOrder Traversal: ");
        tree.PreOrderTraversal(root);
        System.out.println();
        System.out.println("InOrder Traversal: ");
        tree.InOrderTraversal(root);
        System.out.println();
        System.out.println("PostOrder Traversal: ");
        tree.PostOrderTraversal(root);
        System.out.println();
        System.out.println("LevelOrder Traversal :");
        tree.LevelOrderTraversal(root);
        System.out.print("No of Nodes/ count of Nodes/ Size of the tree: ");
        System.out.println(tree.countofNodes(root));
        System.out.print("Height of the Tree: ");
        System.out.println(tree.height(root));
        System.out.print("Diameter of the tree: ");
        System.out.println(tree.diameter(root));
        System.out.print("Optimzed Diameter: ");
        System.out.println(tree.diameterOptimized(root).diam);
        System.out.print("Optimzed Height: ");
        System.out.println(tree.diameterOptimized(root).ht);


    }


}
