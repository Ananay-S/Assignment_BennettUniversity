package DSA_11_BinaryTreeStructure.Practice_11;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;


public class P_02_ReverseLevelOrder {
    class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    // m1
    static ArrayList<Integer> al = new ArrayList<>();
    static int height(Node root) {
        if (root==null) return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }
    static void addLevel(Node root, int l) {
        if (root==null) return;
        if (l==1) al.add(root.data);
        else if (l>1) {
            addLevel(root.left, l-1);
            addLevel(root.right, l-1);
        }
    }
    static ArrayList<Integer> m1(Node node) {
        int h = height(node);
        for (int i = h; i > 0; i--) {
            addLevel(node, i);
        }
        return al;
    }

    // m2
    // void levelOrder(Node node) {
    //     Queue<Node> q = new LinkedList<>();
    //     q.add(node);
    //     while (!q.isEmpty()) {
    //         Node c = q.poll();
    //         System.out.print(c.data+" ");
    //         if (c.left!=null) {
    //             q.add(c.left);
    //         }
    //         if (c.right!=null) {
    //             q.add(c.right);
    //         }
    //     }
    // }
    static ArrayList<Integer> m2(Node node) {
        ArrayList<Integer> al =new ArrayList<>();
        Stack<Node> s = new Stack<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node c = q.poll();
            s.push(c);
            if (c.right!=null) {
                q.add(c.right);
            }
            if (c.left!=null) {
                q.add(c.left);
            }
        }

        while (!s.isEmpty()) {
            al.add(s.pop().data);
        }

        return al;
    }

    // m3
    // static void addNodesToMap(Node node, int level, Map<Integer, List<Integer>> nodeMap) {
    //     if (node == null) {
    //         return;
    //     }
    //     // Add the current node to the list of
    //     // nodes at its level in the hashmap
    //     if (!nodeMap.containsKey(level)) {
    //         nodeMap.put(level, new ArrayList<>());
    //     }
    //     nodeMap.get(level).add(node.data);
    //     // Recursively traverse the left and
    //     // right subtrees
    //     addNodesToMap(node.left, level + 1, nodeMap);
    //     addNodesToMap(node.right, level + 1, nodeMap);
    // }

    // static List<Integer> reverseLevelOrder(Node root) {
    //     List<Integer> result = new ArrayList<>();
    //     // Create a map to store the nodes at each level of the binary tree
    //     Map<Integer, List<Integer>> nodeMap = new HashMap<>();
    //     // Traverse the binary tree recursively and
    //     // add nodes to the hashmap
    //     addNodesToMap(root, 0, nodeMap);
    //     // Iterate over the hashmap in reverse order of the
    //     // levels and add nodes to the result list
    //     for (int level = nodeMap.size() - 1; level >= 0; level--) {
    //         List<Integer> nodesAtLevel = nodeMap.get(level);
    //         for (int i = 0; i < nodesAtLevel.size(); i++) {
    //             result.add(nodesAtLevel.get(i));
    //         }
    //     }
    //     return result;
    // }

    // m4
    

    public static void main(String[] args) {
        

        // leetcode 107 (know the level)
        // bt/ bfs 

        // m1 (brute force)
        // time O(n^2)
        // space O(h)

        // m2 (modified leveloder traversal)
        // time O()
        // space O()

        // m3 (hashmap)
        // time O()
        // space O()


    }
}
