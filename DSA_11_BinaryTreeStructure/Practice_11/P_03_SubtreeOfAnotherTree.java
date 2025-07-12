package DSA_11_BinaryTreeStructure.Practice_11;

public class P_03_SubtreeOfAnotherTree {
    
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

    // m9
    static boolean bool = false;
    static boolean m9(TreeNode root, TreeNode subRoot) {
        if (root==null && subRoot==null) {
            return true;
        }
        if (root==null || subRoot==null) {
            return false;
        }
        System.out.println(root.val +" "+subRoot.val+" "+bool);
        if (root.val==subRoot.val) {
            bool = true;
            if (m1(root.left, subRoot.left)&&m1(root.right, subRoot.right)) return true;
            else {
                bool = false;
                return false;
            }

            // return m1(root.left, subRoot.left)&&m1(root.right, subRoot.right);
        }
        if (bool) {
            bool = false;
            return bool;
        } else {
            return m1(root.left, subRoot)||m1(root.right, subRoot);
        }
        
    }
    // m1
    static boolean isIdentical(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;
        if (p==null || q==null) return false;
        if (p.val==q.val) {
            return isIdentical(p.left, q.left)&&isIdentical(p.right, q.right);
        } else {
            return false;
        }
    }
    static boolean m1(TreeNode root, TreeNode subRoot) {
        if ((root==null && subRoot==null) || (root!=null && subRoot==null)) {
            return true;
        }
        if (root==null && subRoot!=null) {
            return false;
        }
        if (root.val==subRoot.val) {
            if (isIdentical(root, subRoot)) return true;   
        }
        return m1(root.left, subRoot)||m1(root.right, subRoot);
    }
    // m2
    static boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root==null && subRoot==null) return true;
        if (root==null || subRoot==null) return false;
        if (root.val == subRoot.val) return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
        return false;
    } 
    static boolean m2(TreeNode root, TreeNode subRoot) {
        if (root==null && subRoot==null) return true;
        if (root==null || subRoot==null) return false;
        if (dfs(root, subRoot)) return true;
        return m2(root.left, subRoot) || m2(root.right, subRoot);
    } 

    public static void main(String[] args) {
        
    }
}
