package DSA_11_BinaryTreeStructure.Practice_11;

import error;retry


public class P_13_CheckIfTreeIsIsomorphic {
    
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    static boolean m1(Node root1, Node root2) {
        if ((root1==null)&& (root2==null)) return true;
        System.out.println("1");
        if ((root1==null)|| (root2==null)) return false;

        boolean r1l = (root1.left==null);
        boolean r1r = (root1.right==null);
        boolean r2l = (root2.left==null);
        boolean r2r = (root2.right==null);
        if (r1l&r1r&r2l&r2r) return true;
        if (r1l&r2l) return m1(root1.right, root2.right);
        if (r1r&r2r) return m1(root1.left, root2.left);
        if (r1l&r2r) return m1(root1.right, root2.left);
        if (r1r&r2l) return m1(root1.left, root2.right);
        if (r1l|r1r|r2l|r2r) return false;


        if ((root1.left.data==root2.left.data)&&(root1.right.data==root2.right.data)) {
            if (m1(root1.left, root2.left)&&m1(root1.right, root2.right)) return true;
        } else if ((root1.left.data==root2.right.data)&&(root1.right.data==root2.left.data)) {
            return m1(root1.left, root2.right)&&m1(root1.right, root2.left);
        } else {
            return false;
        }
        return false;
    }
    

    public static void main(String[] args) {
        
    }
}
