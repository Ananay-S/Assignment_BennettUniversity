package DSA_11_BinaryTreeStructure.Practice_11;

import java.util.ArrayList;

public class P_18_borderTraversal {
    
    class Node  { 
    int data; 
    Node left, right; 
    public Node(int d)  { 
        data = d; 
        left = right = null; 
        } 
    }

    // m1 recursive or iterative using while
    void lBoundary(Node root, ArrayList<Integer> res) { //without leftmost leaf
        if (root==null) return;

        if (root.left!=null) {
            res.add(root.data);
            lBoundary(root.left, res);
        } else if (root.right!=null) {
            res.add(root.data);
            lBoundary(root.right, res);
        }
    }
    void bBoundary(Node root, ArrayList<Integer> res) { // leaf nodes
        if (root == null) return;

        bBoundary(root.left, res);

        if (root.left==null && root.right==null) {
            res.add(root.data);
        }

        bBoundary(root.right, res);
    }
    void rBoundary(Node root, ArrayList<Integer> res) { //without rightmost leaf
        if (root==null) return;

        if (root.right!=null) {
            rBoundary(root.right, res);
            res.add(root.data);
        } else if (root.left!=null) {
            rBoundary(root.left, res);
            res.add(root.data);
        }
    }

    ArrayList<Integer> boundary(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root==null)  return res;
        res.add(root.data);
        if (root.left==null && root.right==null) return res;
        lBoundary(root.left, res);
        bBoundary(root, res);
        rBoundary(root.right, res);
        return res;
    }




    
}
