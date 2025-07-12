package DSA_11_BinaryTreeStructure.Practice_11;

public class P_14_IsSame {
 
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
    
    // m1
    static boolean m1(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;
        if (p==null || q==null) return false;
        if (p.val==q.val) {
            return m1(p.left, q.left)&&m1(p.right, q.right);
        } else {
            return false;
        }
    }
    // or
    static boolean m2(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;
        if (p==null || q==null) return false;
        if (p.val!=q.val) return false;
        return m2(p.left, q.left)&&m2(p.right, q.right);
    }

    public static void main(String[] args) {
        
    }
}
