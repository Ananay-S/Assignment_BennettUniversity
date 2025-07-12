package DSA_12_BinarySearchTree.Practice_12;

public class P_12_FindInRange {
    
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left=right=null;
        }
    }

    // trial1
    int getCount(Node root,int l, int h) {
        //Your code here
        if (root==null) return 0;
        if (l>root.data || root.data>h) return 0;
        
        int lc = getCount(root.left, l, h);
        int rc = getCount(root.right, l, h);
    
        return lc+rc+1;
    }

    // m1
    int m1(Node root, int l, int h) {
        return util(root, l, h, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    int util(Node root, int l, int h, int min, int max){
        if (root==null) return 0;
        
        int lc = util(root.left, l, h, min, root.data);
        
        if (l>max || min>h) return 0;

        int rc = util(root.right, l, h, root.data, max);
    
        if (l>root.data || root.data>h) return lc+rc;
        return lc+rc+1;
    }
}
