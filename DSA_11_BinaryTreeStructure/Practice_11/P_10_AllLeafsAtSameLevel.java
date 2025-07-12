package DSA_11_BinaryTreeStructure.Practice_11;

public class P_10_AllLeafsAtSameLevel {
    

    class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    // m1
    static boolean m1(Node root) {
        return Util(root, 0, new int[1]);
    }
    static boolean Util(Node root, int level, int[] leafLevel) {
        if (root==null) return true;

        if (root.left==null && root.right==null) {
            // check if first leaf
            if (leafLevel[0]==0) leafLevel[0] = level;
            // check if same level as last leaf
            if (leafLevel[0]!=level) return false;
            return true;
        }

        return Util(root.left, level+1, leafLevel) && Util(root.right, level+1, leafLevel);
    }


    public static void main(String[] args) {
        
    }
}
