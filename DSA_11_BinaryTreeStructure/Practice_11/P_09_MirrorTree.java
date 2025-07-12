package DSA_11_BinaryTreeStructure.Practice_11;

public class P_09_MirrorTree {
    
    static class TreeNode {
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
    static TreeNode m1(TreeNode root) {
        if (root==null) return root;
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        m1(root.left);
        m1(root.right);

        return root;
    }

    // m2 to create a copy
    static TreeNode m2(TreeNode root) {
        if (root==null) return null;

        TreeNode mirror = new TreeNode(root.val);

        mirror.right = m2(root.left);
        mirror.left = m2(root.right);

        return mirror;
    }
    public static void main(String[] args) {
        //invert the tree
    }
}
