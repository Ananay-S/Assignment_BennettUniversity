package DSA_12_BinarySearchTree.Practice_12;


public class P_02_Serach {

    class Node {
        int val;
        Node left, right;
        public Node(int item) {
            val = item;
            left = right = null;
        }
    }
    Node searchr(Node root, int key) {
        if (root==null) return null;
        if (root.val==key) return root;
        if (key<root.val) {
            return searchr(root.left, key);
        } else {
            return searchr(root.right, key);
        }
    }
    Node searchi(Node root, int key) {
        while (root!=null) {
            if (root.val==key) return root;
            if (key<root.val) {
                root=root.left;
            } else {
                root=root.right;
            }
        }
        return null;
    }
}