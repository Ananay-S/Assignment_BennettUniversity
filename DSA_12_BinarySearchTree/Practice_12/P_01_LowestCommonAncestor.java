package DSA_12_BinarySearchTree.Practice_12;




public class P_01_LowestCommonAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // m1 bt 
    // space O(n) 
    // time O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // case-1 null    
        if (root==null) return null;
        // case-2 node itself
        if(root==p || root==q) return root;
        // case-4 one side
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l==null) return r;
        if (r==null) return l;
        // case-3 both side
        return root;
    }
    // m2 bst
    // space O(logn) 
    // time O(logn)
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return null;
        if (p.val<root.val && q.val<root.val) {
            return lowestCommonAncestor2(root.left, p, q);
        }else if (p.val>root.val && q.val>root.val) {
            return lowestCommonAncestor2(root.right, p, q);
        }else{
           return root; 
        }
    }
    // m2 bst iterative
    // space O(1) 
    // time O(logn)
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null) {
            if (p.val<root.val && q.val<root.val) {
                root=root.left;
            }else if (p.val>root.val && q.val>root.val) {
                root=root.right;
            }else{
               return root; 
            }
        }
        return null;
    }
}
