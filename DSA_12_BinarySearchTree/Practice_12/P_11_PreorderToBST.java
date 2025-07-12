package DSA_12_BinarySearchTree.Practice_12;

public class P_11_PreorderToBST {

    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    public Node Bst(int pre[], int size) {
        // code here
        return build(pre, new int[1], Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static Node build(int pre[], int idx[], int min, int max) {
        if (idx[0]>=pre.length) return null;
        int data = pre[idx[0]];
        if (min<data && data<max) {
            Node node = new Node(data);
            idx[0]++;
            node.left = build(pre, idx, min, data);
            node.right = build(pre, idx, data, max);
            return node;
        }else {
            return null;
        } 
    }
}
