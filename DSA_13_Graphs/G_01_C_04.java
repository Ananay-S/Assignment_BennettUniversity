package DSA_13_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class G_01_C_04 {
    
    // TOPOLOGICAL SORT 
    // _____________________________________________________________________
    // Topological Sort using dfs util 
    static void toplogicalSortDfsUtil(ArrayList<ArrayList<Integer>> list, boolean[] vis, Stack<Integer> stack, int v) {
        vis[v] = true;
        for(int i:list.get(v)) {
            if(!vis[i]){
                toplogicalSortDfsUtil(list, vis, stack, i);
            }
        }
        stack.push(v); 
    }
        // list- adjacency list, v- no. of vertex
    static int[] toplogicalSortDfs(ArrayList<ArrayList<Integer>> list, int v) {
        boolean vis[] = new boolean[v];
        Stack<Integer> stack = new Stack<>(); // result

        for (int i = 0; i < v; i++) {
            if(!vis[i]) {
                toplogicalSortDfsUtil(list, vis, stack, i);
            }
        }

        int i=0;
        int[] result = new int[v];
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }

        return result;
    }

    // _____________________________________________________________________
    // Topological Sort using bfs util (Khans algorithm)
        // indegree - no. of incoming edges
        // outdegree - no. of outgoing edges
    static void toplogicalSortBfsUtil(ArrayList<ArrayList<Integer>> list, int[] inDegree, boolean vis[], ArrayList<Integer> queue, int v) {

        // declare
        Queue<Integer> q = new LinkedList<>();
        // initialise
        for (int i = 0; i < v; i++) {
            if (inDegree[i]==0) q.add(i);
        }

        while (!q.isEmpty()) {
            int pt = q.poll();
            queue.add(pt);
            for(int next : list.get(pt)) {
                if (--inDegree[next]==0) q.add(next);
            }
        }

    }
    static int[] toplogicalSortBfs (ArrayList<ArrayList<Integer>> list, int v) {
        // time - O(e)
        int[] inDegree = new int[v];
        for(ArrayList<Integer> adj : list) {
            for(int i : adj) {
                inDegree[i]++;
            } 
        }

        boolean[] vis = new boolean[v];
        ArrayList<Integer> queue = new ArrayList<>();

        toplogicalSortBfsUtil(list, inDegree, vis, queue, v);

        int i = 0;
        int[] result = new int[v];
        for (int j : result) {
            result[i++] = j;
        }

        return result;
    }
}
