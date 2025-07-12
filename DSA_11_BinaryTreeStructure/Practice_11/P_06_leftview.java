package DSA_11_BinaryTreeStructure.Practice_11;

// import java.util.ArrayList;

// import java.util.LinkedList;
// import java.util.Queue;

public class P_06_leftview {
    
    // private static void printLeftView(Node root)
    // {
    //     if (root == null)
    //         return;
 
    //     Queue<Node> queue = new LinkedList<>();
    //     queue.add(root);
 
    //     while (!queue.isEmpty()) {
    //         // number of nodes at current level
    //         int n = queue.size();
 
    //         // Traverse all nodes of current level
    //         for (int i = 1; i <= n; i++) {
    //             Node temp = queue.poll();
 
    //             // Print the left most element at
    //             // the level
    //             if (i == 1)
    //                 System.out.print(temp.data + " ");
 
    //             // Add left node to queue
    //             if (temp.left != null)
    //                 queue.add(temp.left);
 
    //             // Add right node to queue
    //             if (temp.right != null)
    //                 queue.add(temp.right);
    //         }
    //     }
    // }


    // Left view
    // void leftViewUtil(Node node, ArrayList<Node> list, int level) {
    //     if (node==null) return;

    //     // try {
    //     //     list.get(level);
    //     // } catch (Exception e) {
    //     //     // TODO: handle exception
    //     //     list.add(node);
    //     // }
    //     if (list.size()<=level) {
    //         list.add(node);
    //     }
    //     leftViewUtil(node.left, list, level+1);
    //     leftViewUtil(node.right, list, level+1);
    // }
    // void leftView(Node node) {
    //     ArrayList<Node> list = new ArrayList<>();
    //     leftViewUtil(node, list, 0);
    //     for (Node pt : list) {
    //         System.out.print(pt.data+" ");
    //     }System.out.println();
    //     // return list;
    // }
    public static void main(String[] args) {
        
    }
}
