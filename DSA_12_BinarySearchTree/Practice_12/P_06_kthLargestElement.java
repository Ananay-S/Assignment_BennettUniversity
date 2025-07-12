package DSA_12_BinarySearchTree.Practice_12;

import java.util.ArrayList;

public class P_06_kthLargestElement {

    class Node {
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data = data;
            left=null;
            right=null;
        }
    }

    // kthLargest
    
    // m-1
    //      (reverse inorder traversal)
    // time O(n)
    // space O(n) reverse inorder auxillary array (decsending array) 

    public int m1(Node root,int K) {
        //Your code here
        ArrayList<Integer> revIn = new ArrayList<>();
        reverseInorder(root, revIn);
        return revIn.get(K-1);
    }
    public void reverseInorder(Node root, ArrayList<Integer> revIn) {
        if(root==null) return;
        reverseInorder(root.right, revIn);
        revIn.add(root.data);
        reverseInorder(root.left, revIn);
    }

    // m-2
    //      (reverse inorder traversal and start a counter at leaf node)
    // time O(n)
    // space O(h) recurrsion stack 

    public int m2(Node root,int K) {
        //Your code here
        return util(root, K, new int[1]);
    }
    public int util(Node root, int k, int idx[]) {
        if(root==null) return -1;
        
        int r = util(root.right, k, idx);
        
        idx[0]++;
        if(idx[0]==k) return root.data;
        
        int l = util(root.left, k, idx);
        
        if (l==-1) return r;
        return l;
    }

    // m-3
    //      (treaded tree and morris traversal)
    // time O(?)
    // space O(1)  
    
    static int kthLargest(Node root, int k) {

        // return -1 if root is null
        if (root == null) return -1;

        Node curr = root;
        int cnt = 0;

        while (curr != null) {

            // if right tree does not exist,
            // then increment the count, check 
            // count == k. Otherwise, 
            // set curr = curr.left
            if (curr.right == null) {
                cnt++;

                // return current Node
                // if cnt == k.
                if (cnt == k) return curr.data;

                curr = curr.left;
            } else {
                Node succ = curr.right;

                // find the inorder successor
                while (succ.left != null && 
                       succ.left != curr) {
                    succ = succ.left;
                }

                // create a linkage between succ and curr
                if (succ.left == null) {
                    succ.left = curr;
                    curr = curr.right;
                } else {
                    cnt++;

                    // remove the link
                    succ.left = null;

                    // return current Node
                    // if cnt == k.
                    if (cnt == k) return curr.data;

                    curr = curr.left;
                }
            }
        }

        return -1;
    }
}