package DSA_10_BackTracking.Practice_10;

import java.util.ArrayList;

public class P_01_RatInMaze {

    // m1
    static String d = "UDLR";
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static boolean isValid(int[][] maze, int n, int row, int col) {
        return ((row>=0 && col>=0) && (row<n && col<n) && (maze[row][col]==1));
    }
    static void m1(int[][] maze, int n, int row, int col, ArrayList<String> list, StringBuilder str) {
        // base case
        if (row==n-1 && col==n-1) {
            list.add(str.toString());
            return;
        }
        //mark current block
        maze[row][col]=0;
        // 
        for (int i = 0; i < 4; i++) {
            // next possible steps
            int nr = row + dr[i];
            int nc = col + dc[i];
            // 
            if (isValid(maze, n, nr, nc)) {
                str.append(d.charAt(i)); // append
                m1(maze, n, nr, nc, list, str); // recurcive call
                str.deleteCharAt(str.length()-1); // remove append backtrack
            }
        }
        // remove mark backtrack
        maze[row][col] = 1;
    }
    public static void main(String[] args) {
        int[][] maze = {{ 1, 0, 0, 0 },
                        { 1, 1, 0, 1 },
                        { 1, 1, 0, 0 },
                        { 0, 1, 1, 1 }};
        int n = maze.length;

        ArrayList<String> result = new ArrayList<>();
        StringBuilder currentPath = new StringBuilder();

        if ((maze[0][0]!=0)&&(maze[n-1][n-1]!=0)) {
            m1(maze, n, 0, 0, result, currentPath);
        }

        if (result.size()==0) {
            System.out.println(-1);
        } else {
            for (String path : result) {
                System.out.println(path);
            }
        }
    }    
}