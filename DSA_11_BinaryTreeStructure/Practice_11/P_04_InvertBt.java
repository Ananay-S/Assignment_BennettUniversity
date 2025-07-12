package DSA_11_BinaryTreeStructure.Practice_11;

public class P_04_InvertBt {
    
    class TreeNode {
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

    // m1
    static TreeNode m1(TreeNode root) {
        if (root==null) return root;
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        m1(root.left);
        m1(root.right);

        return root;
    }

    public static void main(String[] args) {
        
    }
}
