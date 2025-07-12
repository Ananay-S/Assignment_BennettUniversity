package DSA_11_BinaryTreeStructure.Practice_11;

public class P_23_MinDisBetweenTwoNode {
    class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    
    // int findDist(Node root, int a, int b) {
    //     if (root==null) return 0;

    //     int l = findDist(root.left, a, b);
    //     int r = findDist(root.right, a, b);

    //     return Math.min(l, r);

    // }
    // int DistUtil(Node root, int a, int b, boolean af, boolean bf, ) {
    //     // case 1 
    //     Node lca = lca(root, a, b);


    // }
    // static int min=0;
    // Node lca(Node node, int n1, int n2) {
    //     // case-4 (none subtree)
    //     if (node==null) return null;
    //     // case-1 (node itself)
    //     if(node.data==n1 || node.data==n2) return node;
    //     // case-3 (one subtree) (both)
    //     Node l = lca(node.left, n1, n2);
    //     Node r = lca(node.right, n1, n2);
    //     if (l==null) return r;
    //     if (r==null) return l;
    //     // case-2 (both subtree) (one each)
    //     return node;
    // }
    // int lcaDist(Node node, int n1, int n2) {
    //     // case-4 (none subtree)
    //     if (node==null) return -1;
    //     // case-1 (node itself)
    //     if(node.data==n1 || node.data==n2) return 0;
    //     // case-3 (one subtree) (both)
    //     int l = lcaDist(node.left, n1, n2);
    //     int r = lcaDist(node.right, n1, n2);
    //     if (l==-1) return r+1;
    //     if (r==-1) return l+1;
    //     // case-2 (both subtree) (one each)
    //     return l+r;
    // }
    int findDist(Node root, int a, int b) {
        // Your code here
        if(a==b)return 0;
        return minDist(root, a, b);
    }
    boolean bf = false; // both found
    int minDist(Node node, int n1, int n2) {
        // case-1 (null node)
        if (node==null) return -1;
        // traverse
        int l = minDist(node.left, n1, n2);
        int r = minDist(node.right, n1, n2);
        
        // case-2 (both null node)
        if (l==-1 && r==-1) {
            // case-a (itself)
            if(node.data==n1 || node.data==n2) return 0;
            // case-b (null node)
            return -1;
        }
        
        // case-3 (one null node) (one found)
        if (l==-1 || r==-1) {
            // case-a (pass)
            if (bf) {
                if (l==-1) return r;
                if (r==-1) return l;
            }
            // case-b (two found) (itself)
            if(node.data==n1 || node.data==n2) bf = true;
            
            // case-c (one found)
                // only common

            // common for case-3
            if (l==-1) return r+1;
            if (r==-1) return l+1;
        }
        // case-4 (no null node) (two found)
        bf = true;
        return l+r+2;
        
    }
}
