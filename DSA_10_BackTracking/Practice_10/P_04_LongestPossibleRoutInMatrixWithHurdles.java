package DSA_10_BackTracking.Practice_10;

public class P_04_LongestPossibleRoutInMatrixWithHurdles {

    // m1
    static class Pair {
        boolean found;
        int val;
        Pair(boolean found, int val) {
            this.found = found;
            this.val = val;
        }
    }

    static Pair findLongestPath(int[][] matrix, int i, int j, int x, int y, boolean[][] visited) {
        if (i==x && j==y) {
            return new Pair(true, 0);
        }

        int r = matrix.length;
        int c = matrix[0].length;

        if ((i<0||j<0)||(i>=r||j>=c)||(matrix[i][j]==0)||visited[i][j]) return new Pair(false, -1);

        visited[i][j] = true;

        int result = -1;

        Pair sol;

        sol=findLongestPath(matrix, i, j-1, x, y, visited);
        if (sol.found) result = Math.max(result, sol.val);

        sol=findLongestPath(matrix, i-1, j, x, y, visited);
        if (sol.found) result = Math.max(result, sol.val);
        
        sol=findLongestPath(matrix, i, j+1, x, y, visited);
        if (sol.found) result = Math.max(result, sol.val);
        
        sol=findLongestPath(matrix, i+1, j, x, y, visited);
        if (sol.found) result = Math.max(result, sol.val);

        visited[i][j] = false; // backtrack

        if (result != -1) {
            return new Pair(true, result+1);
        } else {
            return new Pair(false, -1);
        }
    }

    static void m1(int[][] matrix, int i, int j, int x, int y) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        Pair p = findLongestPath(matrix, i, j, x, y, visited);

        System.out.println(p.val);

    }

    // m2
    static int m2(int[][] matrix, int i, int j, int x, int y, int n, int m, int path, int max ) {
        if (i==x && j==y) {
            max = Math.max(max, path);
            return max;
        }

        if (matrix[i][j]==0||matrix[x][y]==0) return max;

        matrix[i][j] = 0;
        
        // left
        if ((j>0)&&matrix[i][j-1]>0) {
            max = m2(matrix, i, j-1, x, y, n, m, path+1, max);
        }
        // up
        if ((i>0)&&matrix[i-1][j]>0) {
            max = m2(matrix, i-1, j, x, y, n, m, path+1, max);
        }
        // right
        if ((j<m-1)&&matrix[i][j+1]>0) {
            max = m2(matrix, i, j+1, x, y, n, m, path+1, max);
        }
        // down
        if ((i<n-1)&&matrix[i+1][j]>0) {
            max = m2(matrix, i+1, j, x, y, n, m, path+1, max);
        }

        matrix[i][j] = 1;

        return max;
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

        m1(mat, 0, 0, 2, 3);

        System.out.println(m2(mat, 0, 0, 2, 3, mat.length, mat[0].length, 0, -1));
    }
    
}
