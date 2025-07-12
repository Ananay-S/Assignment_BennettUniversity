package DSA_13_Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class G_01_C_03 {
    
    // Adjacency list
    static class AdjacencyList {
        int v, e;
        ArrayList<ArrayList<Integer>> list;

        void addEdge(int src, int dest) {
            list.get(src).add(dest);
            list.get(dest).add(src);
        }

        AdjacencyList(int v, int e) {
            this.v = v;
            this.e = e;
            list = new ArrayList<>();
            for(int i=0; i<v; i++) {
                list.add(new ArrayList<>());
            }
        }
    }
    static class AdjacencyListDir {
        int v, e;
        ArrayList<ArrayList<Integer>> list;

        void addEdge(int src, int dest) {
            list.get(src).add(dest);
        }

        AdjacencyListDir(int v, int e) {
            this.v = v;
            this.e = e;
            list = new ArrayList<>();
            for(int i=0; i<v; i++) {
                list.add(new ArrayList<>());
            }
        }
    }
    // DFS
    static ArrayList<Integer> dfs(int v, ArrayList<ArrayList<Integer>> adjacencyList) {
        boolean[] visited = new boolean[v];
        ArrayList<Integer> traversal = new ArrayList<>();

        // dfsUtil(v, adjacencyList, visited, traversal);
        // if Disconected parts exist
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfsUtil(i, adjacencyList, visited, traversal);
                System.out.println();
            }
        }

        return traversal;
    }
    static void dfsUtil(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> trav) {
        vis[v] = true;
        System.out.print(v+" -> ");
        trav.add(v);
        for(int neighbour:adj.get(v)) {
            if (!vis[neighbour]) {
                dfsUtil(neighbour, adj, vis, trav);
            }
        }
    }
    // Ans-1
    static boolean hasCycle(int v, ArrayList<ArrayList<Integer>> adjacencyList) {
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (hasCycleUtil(i, -1, adjacencyList, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
    static boolean hasCycleUtil(int v,int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[v] = true;
        for(int neighbour:adj.get(v)) {
            if (!vis[neighbour]) {
                if (hasCycleUtil(neighbour, v, adj, vis)) {
                    return true;
                } 
            } else if (neighbour!=parent) {
                return true;
            }
        }
        return false;
    }

    // Ans-2
    static boolean hasCycleDir(int v, ArrayList<ArrayList<Integer>> adjacencyList) {
        boolean[] visited = new boolean[v];
        boolean[] visitedThisComponenet = new boolean[v];
 
        for (int i = 0; i <v; i++) {
            if (!visited[i]) {
                if (hasCycleDirUtil(i, -1, adjacencyList, visited, visitedThisComponenet)) {
                    return true;
                }
            }
        }

        return false;
    }
    static boolean hasCycleDirUtil(int v,int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] visTC) {
        vis[v] = true;
        visTC[v] = true;
        for(int neighbour:adj.get(v)) {
            if (!vis[neighbour]) {
                if (hasCycleDirUtil(neighbour, v, adj, vis,visTC)) {
                    return true;
                } 
            } 
            // else if (neighbour!=parent) return true; always true
            else if (visTC[neighbour]) {
                return true;
            }
        }
        visTC[v] = false;
        return false;
    }

    // Ans 3
    static int[] TopologicalSortDfs(int v, ArrayList<ArrayList<Integer>> adjacencyList) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
 
        for (int i = 0; i <v; i++) {
            if (!visited[i]) {
                TopologicalSortDfsUtil(i, adjacencyList, visited, stack);
            }
        }

        int[] res = new int[v];
        int i=0; 
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }

        return res;
    }
    static void TopologicalSortDfsUtil(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stack) {
        vis[v] = true;

        for(int neighbour:adj.get(v)) {
            if (!vis[neighbour]) {
                TopologicalSortDfsUtil(neighbour, adj, vis, stack);
            }
        }

        stack.push(v);
    }
    public static void main(String[] args) {
        int v=6;
        int e=5;
        AdjacencyList adj = new AdjacencyList(v, e);
        adj.addEdge(0, 1);
        adj.addEdge(0, 2);
        adj.addEdge(1, 3);
        adj.addEdge(1, 4); //4->2
        adj.addEdge(4, 5);

        System.out.println("Depth First Search: ");
        dfs(v, adj.list);

        // DETECT CYCLE

        // Q1 detect cycle in an undirected graph
        System.out.println("Has Cycle: ");
        System.out.println(hasCycle(v, adj.list));


        AdjacencyListDir adjDir = new AdjacencyListDir(5, 5);
        adjDir.addEdge(0, 1);
        adjDir.addEdge(2, 1);
        adjDir.addEdge(3, 2);
        adjDir.addEdge(3, 4);
        adjDir.addEdge(4, 2);
        
        // Q2 detect cycle in a directed graph
            // (problem: could reach to same node from different routs and still not a cyle exist)
        System.out.println("Has Cycle Directed: ");
        System.out.println(hasCycleDir(5, adjDir.list));

        // TOPOLOGICAL SORTING
        // (directed acyclic graphs)
        // Q3 dfs
        System.out.println("Q3) Topological Sort DFS:");
        int[] sortedDfs = TopologicalSortDfs(5, adjDir.list);
        for (int i : sortedDfs) {
            System.out.print(i+" -> ");
        }System.out.println();

    }
}
