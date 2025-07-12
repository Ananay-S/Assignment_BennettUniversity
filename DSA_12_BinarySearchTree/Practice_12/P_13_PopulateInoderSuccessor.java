package DSA_12_BinarySearchTree.Practice_12;


public class P_13_PopulateInoderSuccessor {

    class Node {
        int data;
        Node left, right,next;
    
        public Node(int data){
            this.data = data;
        }
    }
    // same as p_10 Flatten
    public void populateNext(Node root) {
        // code here
        Node dummy = new Node(-1);
        prevNode = dummy;
        inorderUtil(root);
    }
    static Node prevNode;
    static void inorderUtil(Node currNode) {
        if(currNode==null) return;
        inorderUtil(currNode.left);
        prevNode.next=currNode;
        prevNode = currNode;
        inorderUtil(currNode.right);
    }

    

    
}