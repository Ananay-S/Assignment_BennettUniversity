package DSA_13_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class G_01_C_02 {

    static class AdjacencyMatrix {
        int v, e;
        int matrix[][];// each 1 denotes an edge

        void addEdge(int src, int dest) {
            matrix[src][dest] = 1;
            matrix[dest][src] = 1;
        }

        AdjacencyMatrix(int v, int e) {
            this.v = v;
            this.e = e;
            matrix = new int[v+1][v+1]; 
        }
    } 

    static class AdjacencyList {
        int v, e;
        ArrayList<LinkedList<Integer>> list;

        void addEdge(int src, int dest) {
            list.get(src).add(dest);
            list.get(dest).add(src);
        }

        AdjacencyList(int v, int e) {
            this.v = v;
            this.e = e;
            list = new ArrayList<>();
            for(int i=0; i<v; i++) {
                list.add(new LinkedList<>());
            }
        }
    }
    public static void main(String[] args) {
        
        // graphs
        //     parts
        //         edges (e)
        //         vertices (v)
        //     representation
        //         Adjacency Matrix (space O(v^2))
        //         Adjacency list (space O(2e + v))


    }
}
