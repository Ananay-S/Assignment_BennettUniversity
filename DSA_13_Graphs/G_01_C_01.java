package DSA_13_Graphs;

import java.util.ArrayList;

// Graph
    // Adjacency list    
    // Array of ArrayList
class Edge {
    int src;
    int dest;
    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}
class weightedEdge {
    int src, dest, weight;
    weightedEdge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}
class Graph { 
    int v=4;
    ArrayList<Edge> graph[] = new ArrayList[v];

    void create() {
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<Edge>();
        }
    }

    void enterData() {
        // v=4;
        
    }

    
}
public class G_01_C_01 {
    
    public static void main(String[] args) {
        // Adjacency list 
        // ArrayList of ArrayList
        // Hashmap
        // Array of ArrayList
        // space O() (no extra space)
        Graph g = new Graph();
        g.create();   
        g.enterData();
            // print 2's neighbours
            for (int i = 0; i < g.graph[2].size(); i++) {
                Edge e = g.graph[2].get(i);
                System.out.print(e.dest+" ");
            } System.out.println();
    }
}

// Graph
    // Structure
        // Vetex or vertices
        // edges 
            // uni-directional (directed)
            // bi-directional (undirectional) (undirected)
            // weighted
            // unweighted
    // Space
        // Adjacency list (sparse)
        // Adjacency matrix (dense)
        // Edge list
        // 2D Matrix (Implicit)

// Applications of graph
    // maps
    // social network
    // delivery network

// Traverse
    // neighbours
    // dfs
    // bfs

// cycle detection
    // directed graph
        // dfs/ bfs/ topological sort(khan's)/ graph colouring
    // undirected graph
        // dfs/ bfs/ dsu(disjoint set union)

// shortest path algorithms (weighted) relaxation (source to vertices)
    // dijkstra's algorithm (bfs) (type of greedy algo) (queue/ priority queue) (only works for +ve weight)
        // O(e+elogv)
    // bellman ford algorithm (type of dynamic programming) (works for both+ve and -ve values)
        // O(e*v)

// minimum spanning tree (mst) (undirectred/ connected/ weighted)
    // subgraph with all vertices and no cycles and min edge weight 
    // Prims algorithm

// Strongly connected component (scc) (only for directed graphs)
    // it is a componenet in which we can reach every vertex of the componenet fro every other vertex
    // Kosaraju's algorithm (reverse dfs)
        // topological sort to stack (v+e)
        // transpose the graph (v+e)
        // do dfs according to the stack on the transpose (v+e)

// Bridge (mostly undirected graph)
    // it deletion increases the graph's number of connected componenets
    // Tarjan's algorithm (works on dfs)(discovery time/ lowest discovery time) (used for:) 
        // topological sort/ Scc/ Bridge/ Articulation