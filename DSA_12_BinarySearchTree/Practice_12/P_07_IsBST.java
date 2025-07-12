package DSA_12_BinarySearchTree.Practice_12;

import java.util.ArrayList;

public class P_07_IsBST {
    class Node {
        int data;
        Node left, right;
    
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    public static boolean isBST(Node root) {
        return util(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean util(Node root, long min, long max) {
        if (root==null) return true;
        if (((min<root.data)&(root.data<max))) {
            boolean l = util(root.left, min, root.data);
            boolean r = util(root.right, root.data, max);
            return l&r;
        }
        return false;
    }

    public static boolean isBST1(Node root) {
        ArrayList<Integer> in = new ArrayList<>();
        inorder(root, in);
        for (int i = 0; i < in.size()-1; i++) {
            if (in.get(i)>in.get(i+1)) return false;
        }
        return true;
    }

    static void inorder(Node root, ArrayList<Integer> in) {
        if (root==null) return;
        inorder(root.left, in);
        in.add(root.data);
        inorder(root.right, in);
    }
    

    
}
