package DSA_11_BinaryTreeStructure.Practice_11;

public class P_24_KthParent {
    
    class Node {
        int data;
        Node left, right;
    };
    int k = 6;
    Node kth(Node root, int d) {
        if (root==null) return null;

        Node l = kth(root.left, d);
        Node r = kth(root.right, d);

        if ((root.data==d)||(l!=null)||(r!=null)) {
            if (k>0) k--;  
            if (k==0) {
                System.out.println("kth parent: "+root.data);
                return null;
            }
            return root;
        }
        return null;
    }
}
