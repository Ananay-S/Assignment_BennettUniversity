package DSA_11_BinaryTreeStructure.Practice_11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class P_17_digonalTraversal {
    
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class LeftLevelNode {
        Node node;
        int level;
        LeftLevelNode(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    // digonal treaversal //modified level order traversal
    public static List<Integer> m1(Node root) {
        if (root == null) return null;

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<LeftLevelNode> q = new LinkedList<LeftLevelNode>();
        q.add(new LeftLevelNode(root, 0));

        while (!q.isEmpty()) {
            LeftLevelNode currentNode = q.poll();
            map.putIfAbsent(currentNode.level, new ArrayList<>());
            map.get(currentNode.level).add(currentNode.node.data);
            if (currentNode.node.left!=null) {
                q.add(new LeftLevelNode(currentNode.node.left, currentNode.level+1));
            }
            if (currentNode.node.right!=null) {
                q.add(new LeftLevelNode(currentNode.node.right, currentNode.level+1));
            }
        }

        List<Integer> traversal = new ArrayList<>();

        for (int i : map.keySet()) {
            List<Integer> l = map.get(i);
            for (int j : l) {
                traversal.add(j);
            }
        }

        return traversal;
    }
}
