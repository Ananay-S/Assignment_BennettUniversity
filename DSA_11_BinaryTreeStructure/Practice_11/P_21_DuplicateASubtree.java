package DSA_11_BinaryTreeStructure.Practice_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class P_21_DuplicateASubtree {
    
    class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static boolean isDuplicate(Node sub1, Node sub2) {
        if (sub1==null && sub2==null) return true;
        if (sub1==null || sub2==null) return false; 
        if (sub1.data != sub2.data) return false;
        return isDuplicate(sub1.left, sub2.left) && isDuplicate(sub1.right, sub2.right);
    }
    static boolean duplicatePresent(Node root, HashMap<Integer, LinkedList<Node>> set) {
        if (root == null) return false;
        
        if (set.containsKey(root.data)&& !(root.left==null && root.right==null)) {
            for (Node node : set.get(root.data)) {
                if (isDuplicate(node, root)) return true;    
            }
        }
        if (set.containsKey(root.data)) {
            set.get(root.data).add(root);
        } else {
            LinkedList<Node> temp = new LinkedList<>();
            temp.add(root);
            set.put(root.data, temp);
        }
        

        boolean l = duplicatePresent(root.left, set);
        boolean r = duplicatePresent(root.right, set);


        return l || r;
    }

    // duplicate subtree list with even same leaf node
     List<Node> lst = new ArrayList<>();
     HashSet<Integer> hset = new HashSet<>();
     void dupPresent(Node root, HashMap<Integer, LinkedList<Node>> set) {
        if (root == null) return;
        
        if (set.containsKey(root.data)) {
            for (Node node : set.get(root.data)) {
                if (isDuplicate(node, root)) {
                    if (!hset.contains(root.data)) {
                        hset.add(root.data);
                        lst.add(root);  
                    } 
                }
            }
        }
        if (set.containsKey(root.data)) {
            set.get(root.data).add(root);
        } else {
            LinkedList<Node> temp = new LinkedList<>();
            temp.add(root);
            set.put(root.data, temp);
        }
        

        dupPresent(root.left, set);
        dupPresent(root.right, set);
    }
}
