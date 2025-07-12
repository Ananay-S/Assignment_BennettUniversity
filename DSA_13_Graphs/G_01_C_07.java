package DSA_13_Graphs;

public class G_01_C_07 {
    // DISJOINT SET 
    // operations
    //     make friends
    //     are friends

    // static class DisjointSet {
    //     int[] p;    // parent
    //     int n;

    //     DisjointSet(int n) {
    //         this.n = n;
    //         p = new int[n];
    //         for (int i = 0; i < n; i++) {
    //             p[i] = i;
    //         }
    //     }

    //     // time O(height of the tree)
    //     int find(int x) {
    //         if (p[x] == x) return x;
    //         return find(p[x]);
    //     }

    //     // dependent on find
    //     void union (int a, int b) {
    //         int x = find(a);
    //         int y = find(b);
    //         if (x == y) return;
    //         p[y] = x;
    //     }
    // }

    // union by rank(height)
    // path compression
    // time O(1) ~ O(m*4) m is number of operations and 4 maximum height
    static class DisjointSet {
        int n;
        int[] p;    // parent
        int[] r;    // rank

        DisjointSet(int n) {
            this.n = n;
            p = new int[n];
            r = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
            // r initialised with 0
        }

        // time O(height of the tree)
        int find(int x) {
            if (p[x] != x) p[x] = find(p[x]);
            return x;
        }

        // dependent on find
        void union (int a, int b) {
            int x = find(a);
            int y = find(b);
            
            if (x == y) return;
            
            if (r[x] < r[y]) p[x] = y;
            else if (r[x] > r[y]) p[y] = x;
            else {
                p[y] = x;
                r[x]++;
            }
        }
    }
}
