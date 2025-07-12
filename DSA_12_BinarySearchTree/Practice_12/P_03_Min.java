package DSA_12_BinarySearchTree.Practice_12;


public class P_03_Min {
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    int minValueR(Node root) {
        if (root==null) return -1;
        if (root.left==null) return root.data;
        return minValueR(root.left);
    }
    int minValueI(Node root) {
        while (root!=null) {
            if (root.left==null) {
                return root.data;
            }
            root=root.left;
        }
        return -1;
    }  
}
