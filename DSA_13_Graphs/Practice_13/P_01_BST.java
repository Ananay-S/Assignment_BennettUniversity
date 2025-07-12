package DSA_13_Graphs.Practice_13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P_01_BST {
    
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int v) {
        ArrayList<Integer> traversal = new ArrayList<>();
        boolean[] vis = new boolean[v];
        bfsUtil(adj, 0, vis, traversal);
        return traversal;
    }

    static void bfsUtil(ArrayList<ArrayList<Integer>> adj, int v, boolean[] vis, ArrayList<Integer> traversal) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        vis[v] = true;
        traversal.add(v);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int neighbour : adj.get(u)) {
                if (!vis[neighbour]) {
                    q.add(neighbour);
                    vis[neighbour]=true;
                    traversal.add(neighbour);
                }
            }
        }

    }
}
