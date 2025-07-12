package DSA_11_BinaryTreeStructure.Practice_11;


public class P_11_IsBalanced {
    
    class Node {
        int data;
        Node left,right;
        
        Node(int d)
        {
            data = d;
            left = right = null;		
        }
    }

    // m1
    static boolean isBalanced(Node root) {
        boolean[] b = new boolean[1]; // flag
        b[0]=true;
        heightUtil(root, b);
        return b[0];
    }

    static int heightUtil(Node node, boolean[] b) {
        if (node==null) return 0;

        int l = heightUtil(node.left, b);
        int r = heightUtil(node.right, b);

        if (b[0]) {
            if (Math.abs((l-r))<=1) {
                return 1+Math.max(l, r);
            } else {
                b[0] = false;
                return -1;
            }
        } else {
            return -1;
        }
    }
    
    public static void main(String[] args) {
        
    }
}
