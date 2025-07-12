package DSA_13_Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class G_01_C_06 {
    
    // SHORTEST PATH (single src and multiple dest)
    // _____________________________________________________________________

    // Dikstra's Algorithm (gfg try) (greedy)
        // only +ve edges
        // time O(elogv)

    // normally (only priority queue)
        // pq (as duplicate v are present)
            // time O(e)
            // space O(e)
    // hashing (also hashmap)
        // pq (optimised)
            // time O(v)
            // space O(v)

    static class Path implements Comparable<Path> {
        int v, weight;

        public int compareTo(Path that) {
            return this.weight-that.weight;
        }

        Path(int v,int weight) {
            this.v=v;
            this.weight=weight;
        }
    }
    static int[] minSpanningTree (ArrayList<ArrayList<ArrayList<Integer>>> list, int v, int src) {
        boolean[] vis = new boolean[v];
        PriorityQueue<Path> pq = new PriorityQueue<>();
        int[] result = new int[v];
        Arrays.fill(result, Integer.MAX_VALUE);

        pq.add(new Path(src, 0));
        result[src] = 0;

        while (!pq.isEmpty()) {
            Path pt = pq.poll();
            int u = pt.v;
            if (vis[u]) { // duplicate to v  with different weight from u
                continue;
            }
            // result += pt.weight;
            vis[u] = true;

            for (ArrayList<Integer> next : list.get(u)) {
                int vertex = next.get(0);
                int weight = next.get(1);
                // if (!vis[vertex]) pq.add(new Path(vertex, weight));
                if (result[vertex] > result[u] + weight) {
                    result[vertex] = result[u] + weight;
                    pq.add(new Path(vertex, result[vertex]));
                }
            }
        }

        return result;
    }

    // bellman ford (even negative edges)
        // also -ve edges
        // time O(ev)
        // concept of negative weight cycle (min distance does not mean anything)
    
    static boolean isNegativeWeightCycle(int v, int[][] edges) {
        int[] result = new int[v]; //min distance
        Arrays.fill(result, Integer.MAX_VALUE);

        result[0] = 0;

        for (int i = 1; i < v; i++) {
            for (int j = 0; j < edges.length; j++) {  // e
                int src = edges[j][0];                
                int dest = edges[j][1];                
                int wt = edges[j][2];                
                if (result[src] != Integer.MAX_VALUE && result[dest] > result[src] + wt ) {
                    result[dest] = result[src] + wt;
                }
            }
        }

        for (int j = 0; j < edges.length; j++) {  // e
            int src = edges[j][0];                
            int dest = edges[j][1];                
            int wt = edges[j][2];                
            if (result[src] != Integer.MAX_VALUE && result[dest] > result[src] + wt ) {
                result[dest] = result[src] + wt;
                return true;
            }
        }

        return false;
        // also return result
    }
}
