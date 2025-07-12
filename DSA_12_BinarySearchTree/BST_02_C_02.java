package DSA_12_BinarySearchTree;

public class BST_02_C_02 {
    
    // height balance height difference<2
    class Node {
        int data, height;
        Node left, right;
        Node (int data) {
            this.data = data;
            height = 1;
            left = right = null;
        }
    }

    // extra
    int height(Node root) {
        if (root==null) return 0;
        return root.height;
    } 
    int heightDifference(Node root) {
        if(root==null) return 0;
        return height(root.left)-height(root.right);
    }
    Node insert(Node root, int data) {
        // bst
        if (root==null) return new Node(data);
        if (data<root.data) {
            root.left = insert(root.left, data);
        } else if (data>root.data) {
            root.right = insert(root.right, data);
        } else {
            return root;
        }
        // height balanace
        root.height += Math.max(height(root.left), height(root.right));
        int balance = height(root);
        if (balance<-1 && data>root.right.data) {
            return leftRotate(root); //rr
        }
        if (balance<-1 && data<root.right.data) {
            node.right = rightRoatate(root.right);
            return leftRotate(root); //rl
        }
        if (balance>1 && data<root.left.data) {
            return rightRoatate(root);//ll
        }
        if (balance<-1 && data>root.left.data) {
            root.left = leftRotate(root.left);
            return rightRoatate(root);
        }
    }
    // left rotation
    Node leftRoatate(Node x) {
        Node y = x.right;
        Node yl = y.left;

        y.left = x;
        x.right = yl;

        x.height = 1+Math.max(height(x.left), height(x.right));
        y.height = 1+Math.max(height(y.left), height(y.right));
        
        return y;
    }
    // right rotation
    Node rightRoatate(Node x) {
        Node y = x.left;
        Node yr = y.right;

        y.right = x;
        x.left = yr;

        x.height = 1+Math.max(height(x.left), height(x.right));
        y.height = 1+Math.max(height(y.left), height(y.right));
        
        return y;
    }
}
