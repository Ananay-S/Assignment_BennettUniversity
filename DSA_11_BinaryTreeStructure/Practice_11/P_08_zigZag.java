package DSA_11_BinaryTreeStructure.Practice_11;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class P_08_zigZag {
    
    class Node {
        int data;
        Node left,right;
        Node(int d)
        {
            data=d;
            left=right=null;
        }
    }

    // m1 (modified level order twice for each level and for odd even)
    static ArrayList<Integer> m1(Node node) {
        ArrayList<Integer> al = new ArrayList<>();
        boolean bool = false; // left to right
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 1; i <= n; i++) { // each level at a time
                Node c = q.poll();
                al.add(c.data);
                System.out.println(bool);
                if (bool) { // for l to r or r to l
                    if (c.right!=null) {
                        q.add(node.right);
                    }
                    if (c.left!=null) {
                        q.add(node.left);
                    }
                } else {
                    if (c.left!=null) {
                        q.add(node.left);
                    }
                    if (c.right!=null) {
                        q.add(node.right);
                    }
                }
            }
            bool = !bool;
        }
        return al;
    }

    // m2
    static ArrayList<Integer> m2(Node node) {
        List<List<Integer>> order = new ArrayList<>();
        Util(node, 0, order);
        ArrayList<Integer> al = new ArrayList<>();
        boolean bool = false;
        for (List<Integer> in : order) {
            if (bool) {
                Collections.reverse(in);
            }
            bool = !bool;
            for (int i : in) {
                al.add(i);
            }
        }
        return al;
    }
    static void Util(Node node, int level, List<List<Integer>> list) {
        if (node==null) return;

        if (list.size()==level) list.add(new ArrayList<>());

        list.get(level).add(node.data);

        Util(node.left, level+1, list);
        Util(node.right, level+1, list);
    }


    public static void main(String[] args) {
        
    }
}
