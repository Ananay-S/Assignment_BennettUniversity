package DSA_13_Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class G_01_C_05 {
    
    // MINIMUM SPANNING TREE (weighted undirected connected )

    // _____________________________________________________________________
    // Prims algorithm (gfg try)
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

    // time- pq takes logn
    // time - O(eloge)
    // space - O(e+v)
        // hashing
        // time - O(elogv)
        // space - O(v+v+v)
    static int minSpanningTree (ArrayList<ArrayList<ArrayList<Integer>>> list, int v) {
        boolean[] vis = new boolean[v];
        PriorityQueue<Path> pq = new PriorityQueue<>();

        pq.add(new Path(0, 0));
        int result = 0;
        
        while (!pq.isEmpty()) {
            Path pt = pq.poll();
            int u = pt.v;
            if (vis[u]) { // duplicate to v  with different weight fromu
                continue;
            }
            result += pt.weight;
            vis[u] = true;

            for (ArrayList<Integer> next : list.get(u)) {
                int vertex = next.get(0);
                int weight = next.get(1);
                if (!vis[vertex]) pq.add(new Path(vertex, weight));
            }
        }

        return result;

    }
    // _____________________________________________________________________
    // Kruskals algorithm

    static class Edge implements Comparable<Edge> {
        int src, dest, wt;
        Edge (int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
        public int compareTo(Edge that) {
            return this.wt-that.wt;
        }
    }

    static class DisjointSet {
        int[] p;    // parent
        int n;

        DisjointSet(int n) {
            this.n = n;
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
        }

        int find(int x) {
            if (p[x] == x) return x;
            return find(p[x]);
        }

        void union (int a, int b) {
            int x = find(a);
            int y = find(b);
            if (x == y) return;
            p[y] = x;
        }
    }

    static int minSpanningTreeKurskals (ArrayList<ArrayList<ArrayList<Integer>>> list, int v) {
        boolean[][] vis = new boolean[v][v];
        ArrayList<Edge> edges = new ArrayList<>();
        
        // preprocessing
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                ArrayList<Integer> cur = list.get(i).get(j);
                if (!vis[i][cur.get(0)]) {
                    vis[i][cur.get(0)] = true;
                    vis[cur.get(0)][i] = true;
                    edges.add(new Edge(i, cur.get(0), cur.get(1)));
                }
            }
        }
        
        Collections.sort(edges);
        
        DisjointSet ds = new DisjointSet(v);

        int result = 0;
        int count = 0;
        for (int i = 0; count < v; i++) {
            Edge edge = edges.get(i);
            int x = ds.find(edge.src);
            int y = ds.find(edge.dest);
            if (x != y) {
                ds.union(x, y);
                count++;
                result += edge.wt;
            }
        }

        return result;
    }
}
