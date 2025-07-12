package DSA_11_BinaryTreeStructure.Practice_11;



public class P_15_ConstructBTFromPreInOrder {

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

    // 1st
    // private int j = 0;
    // private int p = 0;

    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     return build(preorder, inorder, Integer.MIN_VALUE);
    // }

    // private TreeNode build(int[] preorder, int[] inorder, int stop) {
    //     if (p >= preorder.length) {
    //         return null;
    //     }
    //     if (inorder[j] == stop) {
    //         ++j;
    //         return null;
    //     }

    //     TreeNode node = new TreeNode(preorder[p++]);
    //     node.left = build(preorder, inorder, node.val);
    //     node.right = build(preorder, inorder, stop);
    //     return node;
    // }

    // 2nd
    // private HashMap<Integer, Integer> inorderMap = new HashMap<>();
    // private int preorderIndex = 0;
    // public TreeNode buildTree(int[] preorder, int[] inorder) {  
    //     for (int i = 0; i < inorder.length; i++) {
    //         inorderMap.put(inorder[i], i);
    //     }   
    //     return helper(preorder, 0, inorder.length - 1);
    // }

    // private TreeNode helper(int[] preorder, int left, int right) {
    //     // Base case: no elements to construct the tree
    //     if (left > right) {
    //         return null;
    //     }
        
    //     // Select the preorderIndex element as the root and increment preorderIndex
    //     int rootValue = preorder[preorderIndex++];
    //     TreeNode root = new TreeNode(rootValue);
        
    //     // Recursively build the left and right subtrees
    //     root.left = helper(preorder, left, inorderMap.get(rootValue) - 1);
    //     root.right = helper(preorder, inorderMap.get(rootValue) + 1, right);
        
    //     return root;
    // }

    public static void main(String[] args) {
        
    }    
}