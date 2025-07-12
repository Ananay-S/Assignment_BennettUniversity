package DSA_11_BinaryTreeStructure.Practice_11;

public class P_12_TransformToSumTree {

    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=null;
            right=null;
        }
    }

    // m1
    static void m1(Node root) {
        sumUtil(root);
    }
    static int sumUtil(Node root) {
        if (root==null) return 0;

        int l = sumUtil(root.left);
        int r = sumUtil(root.right);
        
        int temp = root.data;
        root.data = l+r;

        return temp+root.data;
    }


    public static void main(String[] args) {
        
    }
}
