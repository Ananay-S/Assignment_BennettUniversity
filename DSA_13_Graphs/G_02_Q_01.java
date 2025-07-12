package DSA_13_Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class G_02_Q_01 {
    // breadth first search BFS
            // concept
                // use of queue and bool visited array(use index as element)
            // Q1 find shortest distance between src and dest
            // Q2 find the number of connected components
    
    // Q1
    static boolean ans1(ArrayList<ArrayList<Integer>> list, int src, int dest, int v, int dist[], int pre[]) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean visited[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            visited[i]=false;
            dist[i]=Integer.MAX_VALUE;
            pre[i]=-1;
        }

        q.add(src);
        visited[src]=true;
        dist[src]=0;
        while (!q.isEmpty()) {
            int pt = q.poll();
            for (int i = 0; i < list.get(pt).size(); i++) {
                int ptn = list.get(pt).get(i);
                if (!visited[ptn]) {
                    visited[ptn]=true;
                    dist[ptn] = dist[pt]+1;
                    pre[ptn] = pt;
                    q.add(ptn);

                    if (ptn==dest) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    static int ans2(ArrayList<ArrayList<Integer>> list, boolean visited[], int v) {
        int c=0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                c++;
                ans1(list, i, -1, v, new int[v], new int[v]);
            }
        }
        return c;
    }

    
}
