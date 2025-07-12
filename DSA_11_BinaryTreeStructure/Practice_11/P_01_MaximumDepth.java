package DSA_11_BinaryTreeStructure.Practice_11;

public class P_01_MaximumDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static int m1(TreeNode root) {
        if (root==null) return 0;

        return Math.max(m1(root.left), m1(root.right))+1;
    }

    public static void main(String[] args) {
        
    }
 
}
