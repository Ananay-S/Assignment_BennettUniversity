package DSA_12_BinarySearchTree.Practice_12;

/**
 * P_10_FlattenBSTSortedList
 */
public class P_10_FlattenBSTSortedList {

    static class Node {
        int data;
        Node left;
        Node right;
     
        public Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

    

    // m1 - (making new linked list)
    // time O(n)
    // space O(n) (new flattened tree)

    // m2 - (linked list to store all nodes then in place modification)
    // time O(n)
    // space O(n) (new auxilary linked list)

    
    // m3 - (basic inorder manulpation)
    // time O(n)
    // space O(h) (recurssion stack)

    static Node flatten(Node root) {
        Node dummy = new Node(-1);
        prevNode = dummy;
        inorderUtil(root);

        prevNode.left=null;
        prevNode.right=null;
        
        return dummy.right;
    }
    static Node prevNode;
    static void inorderUtil(Node currNode) {
        if(currNode==null) return;
        inorderUtil(currNode.left);
        prevNode.left=null;
        prevNode.right=currNode;
        prevNode = currNode;
        inorderUtil(currNode.right);
    }
}