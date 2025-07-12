package DSA_05_LinkedList.Practice_05;

public class P_04_DeleteWithoutHead {
    
    public static void main(String[] args) {
        
        // Given only a pointer/reference to a node to be deleted in a singly linked list, how do you delete it?

        // not possible
        // A simple solution is to traverse the linked list until you find the node you want to delete. But this solution requires a pointer to the head node, which contradicts the problem statement.

        // The fast solution is to copy the data from the next node to the node to be deleted and delete the next node. Something like the following.

        // node = node.next
    }
}
