package DSA_11_BinaryTreeStructure.Practice_11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_05_BtLevelorderTraversal {

    // package DSA_11_BinaryTreeStructure;/ BT_01_C

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // m1 BFS
    static List<List<Integer>> m1(TreeNode node) {
        
        List<List<Integer>> res = new LinkedList<>();
        if (node==null) return res;
        
        List<Integer> inRes = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        
        int level = 0;

        queue.add(node);
        levelQueue.add(level);
        
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            int currentLevel = levelQueue.poll();
            
            if (currentLevel>level) {
                res.add(inRes);
                inRes = new ArrayList<>();
                level++;
            }
            inRes.add(currentNode.val);

            if (currentNode.left!=null) {
                queue.add(currentNode.left);
                levelQueue.add(currentLevel+1);
            }
            if (currentNode.right!=null) {
                queue.add(currentNode.right);
                levelQueue.add(currentLevel+1);
            }
        }
        res.add(inRes);

        return res;
    }

    // m2 DFS
    static List<List<Integer>> m2(TreeNode node) {
        List<List<Integer>> order = new ArrayList<>();
        m2Util(node, 0, order);
        return order;
    }
    static void m2Util(TreeNode node, int level, List<List<Integer>> list) {
        if (node==null) return;

        if (list.size()==level) list.add(new ArrayList<>());

        list.get(level).add(node.val);

        m2Util(node.left, level+1, list);
        m2Util(node.right, level+1, list);
    }
    public static void main(String[] args) {
        
        // NOTE LEVELORDER TRAVERSAL NOT SAME AS LEVEL ORDER PRINT BFS AND DFS
    }
}