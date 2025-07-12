package DSA_11_BinaryTreeStructure.Practice_11;

import DSA_11_BinaryTreeStructure.Node;

public class P_23_LCAInBT {
    Node lca(Node node, int n1, int n2) {
        // case-4 (none subtree)
        if (node==null) return null;
        // case-1 (node itself)
        if(node.data==n1 || node.data==n2) return node;
        // case-3 (one subtree) (both)
        Node l = lca(node.left, n1, n2);
        Node r = lca(node.right, n1, n2);
        if (l==null) return r;
        if (r==null) return l;
        // case-2 (both subtree) (one each)
        return node;
    }
}
